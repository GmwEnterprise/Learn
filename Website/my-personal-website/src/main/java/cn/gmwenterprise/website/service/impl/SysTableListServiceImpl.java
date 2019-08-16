package cn.gmwenterprise.website.service.impl;

import cn.gmwenterprise.website.dao.SysTableListDao;
import cn.gmwenterprise.website.domain.SysTableList;
import cn.gmwenterprise.website.generator.ColumnStruct;
import cn.gmwenterprise.website.service.SysTableListService;
import cn.gmwenterprise.website.service.sys.DatabaseService;
import cn.gmwenterprise.website.vo.SysTableListVo;
import com.google.common.base.CaseFormat;
import com.google.common.collect.Maps;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SysTableListServiceImpl implements SysTableListService {
    private final SysTableListDao sysTableListDao;
    private final DatabaseService databaseService;

    public SysTableListServiceImpl(SysTableListDao sysTableListDao, DatabaseService databaseService) {
        this.sysTableListDao = sysTableListDao;
        this.databaseService = databaseService;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysTableListDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysTableListVo vo) {
        return sysTableListDao.insert(domain(vo));
    }

    @Override
    public int insertSelective(SysTableListVo vo) {
        return sysTableListDao.insertSelective(domain(vo));
    }

    @Override
    public SysTableListVo selectByPrimaryKey(Integer id) {
        return vo(sysTableListDao.selectByPrimaryKey(id));
    }

    @Override
    public List<SysTableListVo> selectPage(SysTableListVo vo) {
        return sysTableListDao.selectPage(domain(vo))
            .stream()
            .map(this::vo)
            .collect(Collectors.toList());
    }

    @Override
    public int updateByPrimaryKeySelective(SysTableListVo vo) {
        return sysTableListDao.updateByPrimaryKeySelective(domain(vo));
    }

    @Override
    public int updateByPrimaryKey(SysTableListVo vo) {
        return sysTableListDao.updateByPrimaryKey(domain(vo));
    }

    private static final Map<String, List<ColumnStruct>> COLUMN_LIST_MAP = Maps.newHashMap();

    @Override
    public SysTableListVo selectMoreByPrimaryKey(Integer id) throws Exception {
        SysTableListVo vo = selectByPrimaryKey(id);
        String tableName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, vo.getTableServiceLink());
        List<ColumnStruct> columnStructList;
        List<ColumnStruct> cache = COLUMN_LIST_MAP.get(tableName);
        String pk = "";
        if (cache == null) {
            columnStructList = databaseService.getColumnStructList(tableName);
            columnStructList.forEach(item -> {
                item.setFieldName(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, item.getFieldName()));
                String comment = item.getColumnComment();
                String split = "，";
                if (comment.contains(split)) {
                    item.setColumnComment(comment.split(split)[0]);
                }
            });
            COLUMN_LIST_MAP.put(tableName, columnStructList);
        } else {
            columnStructList = cache;
        }
        vo.setDetailMsg(columnStructList);
        return vo;
    }

    private SysTableListVo vo(SysTableList domain) {
        if (domain == null) {
            return null;
        }
        SysTableListVo vo = new SysTableListVo();
        BeanUtils.copyProperties(domain, vo);
        return vo;
    }

    private SysTableList domain(SysTableListVo vo) {
        if (vo == null) {
            return null;
        }
        SysTableList domain = new SysTableList();
        BeanUtils.copyProperties(vo, domain);
        return domain;
    }
}
