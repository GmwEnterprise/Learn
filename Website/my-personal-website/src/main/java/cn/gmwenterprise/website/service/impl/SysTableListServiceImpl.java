package cn.gmwenterprise.website.service.impl;

import cn.gmwenterprise.website.dao.SysTableListDao;
import cn.gmwenterprise.website.domain.SysTableList;
import cn.gmwenterprise.website.service.SysTableListService;
import cn.gmwenterprise.website.vo.SysTableListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysTableListServiceImpl implements SysTableListService {
    private final SysTableListDao sysTableListDao;

    public SysTableListServiceImpl(SysTableListDao sysTableListDao) {
        this.sysTableListDao = sysTableListDao;
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
    public List<SysTableListVo> selectAll(SysTableListVo vo) {
        return sysTableListDao.selectAll(domain(vo))
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
