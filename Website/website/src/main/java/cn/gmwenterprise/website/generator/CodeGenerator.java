package cn.gmwenterprise.website.generator;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * 代码生成器
 *
 * @author Gmw
 */
public class CodeGenerator {

    public static void main(String[] args) throws Exception {
        InputStream resource = ClassLoader.getSystemResourceAsStream("application.properties");
        Properties properties = new Properties();
        properties.load(resource);
        String url = properties.getProperty("spring.datasource.druid.url");
        String user = properties.getProperty("spring.datasource.druid.username");
        String password = properties.getProperty("spring.datasource.druid.password");
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet writerColumns = metaData.getColumns(null, "%", "writer", "%");

        }
    }
}
