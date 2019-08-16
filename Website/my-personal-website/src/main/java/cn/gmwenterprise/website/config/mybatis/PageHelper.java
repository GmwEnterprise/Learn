package cn.gmwenterprise.website.config.mybatis;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.scripting.xmltags.SqlNode;
import org.apache.ibatis.scripting.xmltags.StaticTextSqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 * 分页插件实现类
 *
 * @author Gmw
 * @date 2019年8月7日 11:16:07
 */
@Slf4j
@Intercepts(
    @Signature(
        type = Executor.class,
        method = "query",
        args = {
            MappedStatement.class,
            Object.class,
            RowBounds.class,
            ResultHandler.class
        }
    )
)
public class PageHelper implements Interceptor {

    private static final ThreadLocal<PageInfo> PAGE_INFO = new ThreadLocal<>();
    private static final ThreadLocal<Page<?>> PAGE_RESULT = new ThreadLocal<>();

    /**
     * 开启分页查询，调用该方法后，该线程下下一个查询语句将返回分页对象
     *
     * @param startPage 起始页
     * @param pageSize  本页条数
     */
    public static void startPage(Integer startPage, Integer pageSize) {
        startPage = startPage != null && startPage > 0 ? startPage : 1;
        PAGE_INFO.remove();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage(startPage);
        pageInfo.setPageSize(pageSize);
        PAGE_INFO.set(pageInfo);
    }

    public static void startPage(Integer startPage) {
        startPage(startPage, null);
    }

    @SuppressWarnings("unchecked")
    public static <E> Page<E> page(List<E> list) {
        Page<E> page = (Page<E>) Objects.requireNonNull(PAGE_RESULT.get());
        page.setList(list);
        return page;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object intercept(Invocation invocation) throws Throwable {
        // 1. 检查线程中是否有分页参数，若没有则不启动分页
        PageInfo pageInfo = PAGE_INFO.get();
        if (!defaultUseFlag || pageInfo == null) {
            return invocation.proceed();
        }
        if (pageInfo.getPageSize() == null) {
            pageInfo.setPageSize(defaultPageSize);
        }
        // 2. 获取未注入参数的sql
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        Object parameterObject = args[1];
        BoundSql boundSql = mappedStatement.getBoundSql(parameterObject);
        MetaObject metaBoundSql = SystemMetaObject.forObject(boundSql);
        String sql = (String) metaBoundSql.getValue("sql");
        // 3. 计算总条数、总页数
        int total = 0;
        String countSql = String.format("select count(1) as total from (%s) $_paging", sql);
        Configuration configuration = mappedStatement.getConfiguration();
        MetaObject metaMappedStatement = SystemMetaObject.forObject(mappedStatement);
        DataSource dataSource = (DataSource) metaMappedStatement.getValue("configuration.environment.dataSource");
        try (PreparedStatement pCount = dataSource.getConnection().prepareStatement(countSql)) {
            BoundSql countBoundSql = new BoundSql(configuration, countSql, boundSql.getParameterMappings(), boundSql.getParameterObject());
            ParameterHandler handler = new DefaultParameterHandler(mappedStatement, boundSql.getParameterObject(), countBoundSql);
            handler.setParameters(pCount);
            ResultSet rs = pCount.executeQuery();
            while (rs.next()) {
                total = rs.getInt("total");
            }
        }
        int totalPage = total % pageInfo.getPageSize() == 0 ? total / pageInfo.getPageSize() : total / pageInfo.getPageSize() + 1;
        // 4. 检测分页参数是否合法
        if (pageInfo.getCurrentPage() > totalPage) {
            log.warn("分页参数不合法！输入页码为[{}], 总页数为[{}]", pageInfo.getCurrentPage(), totalPage);
            // 设置为最后一页
            pageInfo.setCurrentPage(totalPage > 0 ? totalPage : 1);
        }
        // 5. 填入分页参数
        Page<?> page = new Page<>();
        page.setCurrentPage(pageInfo.getCurrentPage());
        page.setPageSize(pageInfo.getPageSize());
        page.setTotal(total);
        page.setTotalPage(totalPage);
        page.setHasNextPage(pageInfo.getCurrentPage() < totalPage);
        page.setHasPrevPage(pageInfo.getCurrentPage() > 1);
        PAGE_RESULT.remove();
        PAGE_RESULT.set(page);
        // 6. 修改sql
        ArrayList<SqlNode> sqlNodes = (ArrayList) metaMappedStatement.getValue("sqlSource.rootSqlNode.contents");
        StaticTextSqlNode end = new StaticTextSqlNode(PAGE_ENDING + (pageInfo.getCurrentPage() - 1) * pageInfo.getPageSize() + ", " + pageInfo.getPageSize());
        if (!SQL_NODES_MAP.containsKey(String.valueOf(System.identityHashCode(sqlNodes)))) {
            StaticTextSqlNode start = new StaticTextSqlNode(PAGE_START);
            sqlNodes.add(0, start);
            SQL_NODES_MAP.put(String.valueOf(System.identityHashCode(sqlNodes)), sqlNodes);
        } else {
            sqlNodes.remove(sqlNodes.size() - 1);
        }
        sqlNodes.add(sqlNodes.size(), end);
        metaMappedStatement.setValue("sqlSource.rootSqlNode.contents", sqlNodes);
        return invocation.proceed();
    }

    private static final Map<String, ArrayList<SqlNode>> SQL_NODES_MAP = Maps.newHashMap();
    private static final String PAGE_START = "select $_paging_list.* from (";
    private static final String PAGE_ENDING = ") $_paging_list limit ";

    /**
     * 从代理对象中分离出真实对象
     *
     * @param target 代理对象
     * @return 非代理对象
     */
    private Object getUnProxyObject(Object target) {
        MetaObject metaObject = SystemMetaObject.forObject(target);
        Object object = null;
        while (metaObject.hasGetter("h")) {
            object = metaObject.getValue("h");
            metaObject = SystemMetaObject.forObject(object);
        }
        return object == null ? target : object;
    }

    /**
     * 默认每页长度
     */
    private int defaultPageSize;
    /**
     * 是否启用插件
     */
    private boolean defaultUseFlag;

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    /**
     * 初始化插件参数，源自于配置文件中提供的参数
     *
     * @param properties 配置的参数
     */
    @Override
    public void setProperties(Properties properties) {
        defaultPageSize = Integer.parseInt(Optional.ofNullable(properties.getProperty("default.pageSize")).orElse("20"));
        defaultUseFlag = Boolean.parseBoolean(Optional.ofNullable(properties.getProperty("default.useFlag")).orElse("true"));
    }
}
