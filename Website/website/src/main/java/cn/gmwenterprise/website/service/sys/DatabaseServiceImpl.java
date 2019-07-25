package cn.gmwenterprise.website.service.sys;

import cn.gmwenterprise.website.cache.Cache;
import cn.gmwenterprise.website.service.sys.DatabaseService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
public class DatabaseServiceImpl implements DatabaseService {
    private Connection connection;
    @Resource(name = "jvm")
    private Cache cache;

    private static final String TABLE_LIST_MSG_KEY = "tableListMsg";

    public DatabaseServiceImpl(DataSource dataSource) throws SQLException {
        connection = dataSource.getConnection();
    }

    @Override
    public List<TableMsg> getTableList() {
        if (cache.exist(TABLE_LIST_MSG_KEY)) {
            return cache.getList(TableMsg.class, TABLE_LIST_MSG_KEY);
        }
        List<TableMsg> tableListData = null;
        try {
            tableListData = getTableListData();
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
        cache.set(TABLE_LIST_MSG_KEY, tableListData);
        return tableListData;
    }

    private List<TableMsg> getTableListData() throws SQLException {
        PreparedStatement p = connection.prepareStatement("SHOW TABLE STATUS FROM `my_website`");
        ResultSet ts = p.executeQuery();
        List<TableMsg> resultList = Lists.newArrayList();
        while (ts.next()) {
            TableMsg tableMsg = new TableMsg();
            tableMsg.setName(ts.getString("Name"));
            tableMsg.setCreateTime(LocalDateTime.parse(
                ts.getString("Create_time"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            tableMsg.setCollection(ts.getString("Collation"));
            tableMsg.setComment(ts.getString("Comment"));
            resultList.add(tableMsg);
        }
        ts.close();
        p.close();
        return resultList;
    }

    public class TableMsg {
        private String name;
        private LocalDateTime createTime;
        private String collection;
        private String comment;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalDateTime getCreateTime() {
            return createTime;
        }

        public void setCreateTime(LocalDateTime createTime) {
            this.createTime = createTime;
        }

        public String getCollection() {
            return collection;
        }

        public void setCollection(String collection) {
            this.collection = collection;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }
}
