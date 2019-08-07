package cn.gmwenterprise.website.config.mybatis;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

/**
 * 分页插件实现类
 *
 * @author Gmw
 * @date 2019年8月7日 11:16:07
 */
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
    public static void startPage(int startPage, Integer pageSize) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage(startPage);
        pageInfo.setPageSize(pageSize);
        PAGE_INFO.set(pageInfo);
    }

    public static void startPage(int startPage) {
        startPage(startPage, null);
    }

    @SuppressWarnings("unchecked")
    public static <E> Page<E> page(List<E> list) {
        Page<E> page = (Page<E>) Objects.requireNonNull(PAGE_RESULT.get());
        page.setList(list);
        return page;
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 1. 检查线程中是否有分页参数，若没有则不启动分页
        /*PageInfo pageInfo = PAGE_INFO.get();
        if (!defaultUseFlag || pageInfo == null) {
            return invocation.proceed();
        }
        if (pageInfo.getPageSize() == null) {
            pageInfo.setPageSize(defaultPageSize);
        }*/
        // 2. 获取sql
//        Executor executor = (Executor) getUnProxyObject(invocation.getTarget());
//        MetaObject metaExecutor = SystemMetaObject.forObject(executor);
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        Object parameterObject = args[1];
        BoundSql boundSql = mappedStatement.getBoundSql(parameterObject);
        MetaObject metaBoundSql = SystemMetaObject.forObject(boundSql);
        // TODO 未完成
        return invocation.proceed();
    }

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
