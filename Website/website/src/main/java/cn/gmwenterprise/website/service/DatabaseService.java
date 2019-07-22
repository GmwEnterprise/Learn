package cn.gmwenterprise.website.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DatabaseService {

    List<Map<String, Object>> getTableList() throws SQLException;
}
