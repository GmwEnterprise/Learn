package cn.gmwenterprise.website.service;

import java.util.List;

public interface DatabaseService {

    List<DatabaseServiceImpl.TableMsg> getTableList();
}
