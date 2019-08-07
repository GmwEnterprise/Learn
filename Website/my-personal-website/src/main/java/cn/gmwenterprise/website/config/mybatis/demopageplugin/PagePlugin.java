package cn.gmwenterprise.website.config.mybatis.demopageplugin;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

/**
 * 分页插件
 *
 * @author Gmw
 */
@Slf4j
@Intercepts(
    @Signature(
        type = StatementHandler.class,
        method = "prepare",
        args = {
            Connection.class, Integer.class
        }
    )
)
public class PagePlugin implements Interceptor {
    private Integer defaultPage;
    private Integer defaultPageSize;
    private Boolean defaultUseFlag;
    private Boolean defaultCheckFlag;
    private Boolean defaultCleanOrderBy;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("进入插件方法");
        StatementHandler stmtHandler = (StatementHandler) getUnProxyObject(invocation.getTarget());
        MetaObject metaStatementHandler = SystemMetaObject.forObject(stmtHandler);
        String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
        if (!checkSelect(sql)) {
            // 不是select语句
            return invocation.proceed();
        }
        BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
        Object parameterObject = boundSql.getParameterObject();
        PageParams pageParams = getPageParamsForParamObj(parameterObject);
        if (pageParams == null) {
            // 无法获取分页参数
            return invocation.proceed();
        }
        Boolean useFlag = pageParams.getUseFlag() == null ? defaultUseFlag : pageParams.getUseFlag();
        if (!useFlag) {
            // 不使用分页插件
            return invocation.proceed();
        }
        Integer pageNum = pageParams.getPage() == null ? defaultPage : pageParams.getPage();
        Integer pageSize = pageParams.getPageSize() == null ? defaultPageSize : pageParams.getPageSize();
        Boolean checkFlag = pageParams.getCheckFlag() == null ? defaultCheckFlag : pageParams.getCheckFlag();
        Boolean cleanOrderBy = pageParams.getCleanOrderBy() == null ? defaultCleanOrderBy : pageParams.getCleanOrderBy();
        // 计算总条数、总页数
        int total = getTotal(invocation, metaStatementHandler, boundSql, cleanOrderBy);
        int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
        // 回填
        pageParams.setTotal(total);
        pageParams.setTotalPage(totalPage);
        // 检查页码有效性
        checkPage(checkFlag, pageNum, totalPage);
        // 修改sql
        return preparedSQL(invocation, metaStatementHandler, boundSql, pageNum, pageSize);
    }

    /**
     * 预编译改写后的sql，并设置分页参数
     *
     * @param invocation           入参
     * @param metaStatementHandler MetaObject绑定的StatementHandler
     * @param boundSql             boundSql对象
     * @param pageNum              当前页
     * @param pageSize             最大页
     */
    private Object preparedSQL(Invocation invocation, MetaObject metaStatementHandler, BoundSql boundSql, Integer pageNum, Integer pageSize) throws Exception {
        // 获取当前需要执行的sql
        String sql = boundSql.getSql();
        String newSql = "select * from (" + sql + ") $_paging_table limit ?, ?";
        // 修改当前需要执行的sql
        metaStatementHandler.setValue("delegate.boundSql.sql", newSql);
        // 执行编译，相当于StatementHandler执行了prepared方法 ，这时候，就剩下两个分页参数没有设置
        Object statementObj = invocation.proceed();
        // 设置两个分页参数
        preparePageDataParams((PreparedStatement) statementObj, pageNum, pageSize);
        return statementObj;
    }

    private void preparePageDataParams(PreparedStatement ps, Integer pageNum, Integer pageSize) throws Exception {
        int idx = ps.getParameterMetaData().getParameterCount();
        ps.setInt(idx - 1, (pageNum - 1) * pageSize);
        ps.setInt(idx, pageSize);
    }

    /**
     * 检查页码有效性
     *
     * @param checkFlag 是否检测
     * @param pageNum   当前页码
     * @param totalPage 总页数
     * @throws Throwable 异常
     */
    private void checkPage(Boolean checkFlag, Integer pageNum, int totalPage) throws Throwable {
        if (checkFlag && pageNum > totalPage) {
            throw new Exception("查询失败，查询页码[" + pageNum + "]大于总页数[" + totalPage + "]!!");
        }
    }

    /**
     * 获取总条数
     *
     * @param invocation           入参
     * @param metaStatementHandler statementHandler
     * @param boundSql             sql
     * @param cleanOrderBy         是否清除order by语句
     * @return 查询总数
     * @throws Throwable 异常
     */
    private int getTotal(Invocation invocation, MetaObject metaStatementHandler, BoundSql boundSql, Boolean cleanOrderBy) throws Throwable {
        // 获取当前的mappedStatement
        MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
        // 配置对象
        Configuration configuration = mappedStatement.getConfiguration();
        // 当前需要执行的sql
        String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
        // 去掉最后的order by
        if (cleanOrderBy) {
            sql = cleanOrderByForSql(sql);
        }
        // 改写为统计总数的sql
        String countSql = "select count(*) as total from (" + sql + ") $_paging";
        // 获取拦截方法参数，根据插件签名，知道是Connection对象
        Connection connection = (Connection) invocation.getArgs()[0];
        PreparedStatement ps = null;
        int total = 0;
        try {
            ps = connection.prepareStatement(countSql);
            BoundSql countBoundSql = new BoundSql(configuration, countSql, boundSql.getParameterMappings(), boundSql.getParameterObject());
            ParameterHandler handler = new DefaultParameterHandler(mappedStatement, boundSql.getParameterObject(), countBoundSql);
            // 设置总数sql参数
            handler.setParameters(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt("total");
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return total;
    }

    private String cleanOrderByForSql(String sql) {
        StringBuilder sb = new StringBuilder(sql);
        String newSql = sql.toLowerCase();
        if (!newSql.contains("order")) {
            return sql;
        }
        int idx = newSql.lastIndexOf("order");
        return sb.substring(0, idx);
    }

    /**
     * 分离出分页参数
     *
     * @param parameterObject 执行参数
     * @return 分页参数
     */
    private PageParams getPageParamsForParamObj(Object parameterObject) throws Exception {
        if (parameterObject == null) {
            return null;
        }
        if (parameterObject instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Object> paramMap = ((Map<String, Object>) parameterObject);
            return (PageParams) paramMap.keySet().stream()
                .map(paramMap::get)
                .filter(value -> value instanceof PageParams)
                .findFirst().orElse(null);
        } else if (parameterObject instanceof PageParams) {
            return (PageParams) parameterObject;
        } else {
            Field[] fields = parameterObject.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getType() == PageParams.class) {
                    PropertyDescriptor pd = new PropertyDescriptor(field.getName(), parameterObject.getClass());
                    Method readMethod = pd.getReadMethod();
                    return (PageParams) readMethod.invoke(parameterObject);
                }
            }
        }
        return null;
    }

    /**
     * 判断sql语句是不是select语句
     *
     * @param sql sql语句
     * @return
     */
    private boolean checkSelect(String sql) {
        return sql.trim().toLowerCase().indexOf("select") == 0;
    }

    /**
     * 从代理对象中分离出真实对象
     *
     * @param target 代理对象
     * @return 非代理StatementHandler对象
     */
    private Object getUnProxyObject(Object target) {
        MetaObject metaStatementHandler = SystemMetaObject.forObject(target);

        Object object = null;
        while (metaStatementHandler.hasGetter("h")) {
            object = metaStatementHandler.getValue("h");
            metaStatementHandler = SystemMetaObject.forObject(object);
        }
        return object == null ? target : object;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        defaultPage = Integer.parseInt(properties.getProperty("default.page", "1"));
        defaultPageSize = Integer.parseInt(properties.getProperty("default.pageSize", "50"));
        defaultUseFlag = Boolean.parseBoolean(properties.getProperty("default.useFlag", "false"));
        defaultCheckFlag = Boolean.parseBoolean(properties.getProperty("default.checkFlag", "false"));
        defaultCleanOrderBy = Boolean.parseBoolean(properties.getProperty("default.cleanOrderBy", "false"));
    }
}
