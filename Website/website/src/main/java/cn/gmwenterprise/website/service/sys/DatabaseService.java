package cn.gmwenterprise.website.service.sys;

import java.util.List;

public interface DatabaseService {

    List<DatabaseServiceImpl.TableMsg> getTableList();
}
