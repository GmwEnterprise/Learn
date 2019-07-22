package cn.gmwenterprise.website.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class DatabaseServiceImpl implements DatabaseService {
    private final Connection connection;

    public DatabaseServiceImpl(DataSource dataSource) throws SQLException {
        connection = dataSource.getConnection();
    }

    @Override
    public List<Map<String, Object>> getTableList() throws SQLException {
        return getTableListData();
    }

    private List<Map<String, Object>> getTableListData() throws SQLException {
        PreparedStatement p = connection.prepareStatement("SHOW TABLE STATUS FROM `my_website`");
        ResultSet ts = p.executeQuery();
        List<Map<String, Object>> resultList = Lists.newArrayList();
        while (ts.next()) {
            String name = ts.getString("Name");
            String createTime = ts.getString("Create_time");
            String collation = ts.getString("Collation");
            String comment = ts.getString("Comment");
            Map<String, Object> table = Maps.newHashMap();
            table.put("name", name);
            table.put("collation", collation);
            table.put("createTime", createTime);
            table.put("comment", comment);
            resultList.add(table);
        }
        return resultList;
    }
}
