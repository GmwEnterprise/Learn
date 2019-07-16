package cn.gmwenterprise.website.generator;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 生成器所依赖的数据库工具
 *
 * @author Gmw
 */
public class DbHelper {

    /**
     * 获取数据库连接
     *
     * @return 连接
     * @throws Exception 异常
     */
    public static Connection getConnection() throws Exception {
        InputStream resource = ClassLoader.getSystemResourceAsStream("application.properties");
        Properties properties = new Properties();
        properties.load(resource);
        String url = properties.getProperty("spring.datasource.druid.url");
        String user = properties.getProperty("spring.datasource.druid.username");
        String password = properties.getProperty("spring.datasource.druid.password");
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 获取数据库所有表名称
     *
     * @param connection 数据库连接
     * @return 表名集合
     * @throws SQLException 数据库异常
     */
    static List<String> getTableNameList(Connection connection) throws SQLException {
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ArrayList<String> tableNameList = new ArrayList<>();
        ResultSet tables = databaseMetaData.getTables(connection.getCatalog(), null, "%", null);
        while (tables.next()) {
            tableNameList.add(tables.getString("TABLE_NAME"));
        }
        return tableNameList;
    }

    static TableStruct getTableStruct(Connection connection, String tableName) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet table = metaData.getTables(connection.getCatalog(), null, tableName, null);

        ResultSet tableColumns = metaData.getColumns(connection.getCatalog(), "%", tableName, "TABLE");

        List<ColumnStruct> columnStructList = new ArrayList<>();

        while (tableColumns.next()) {
            ColumnStruct struct = new ColumnStruct();

            String column_name = tableColumns.getString("COLUMN_NAME");
            int data_type = tableColumns.getInt("DATA_TYPE");
            String remarks = tableColumns.getString("REMARKS");

            struct.setColumnName(column_name);
            struct.setColumnType(data_type + "");
            struct.setColumnComment(remarks);

            columnStructList.add(struct);
        }

        TableStruct tableStruct = new TableStruct();
        tableStruct.setTableName(tableName);
        return tableStruct;
    }

    static TableStruct getAllTableStruct(Connection connection) {
        return null;
    }
}
