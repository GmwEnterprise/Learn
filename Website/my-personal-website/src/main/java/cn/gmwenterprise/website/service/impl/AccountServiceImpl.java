package cn.gmwenterprise.website.service.impl;

import cn.gmwenterprise.website.vo.AccountVo;
import cn.gmwenterprise.website.dao.AccountDao;
import cn.gmwenterprise.website.domain.Account;
import cn.gmwenterprise.website.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return accountDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AccountVo vo) {
        return accountDao.insert(domain(vo));
    }

    @Override
    public int insertSelective(AccountVo vo) {
        return accountDao.insertSelective(domain(vo));
    }

    @Override
    public AccountVo selectByPrimaryKey(Integer id) {
        return vo(accountDao.selectByPrimaryKey(id));
    }

    @Override
    public List<AccountVo> selectAll(AccountVo vo) {
        return accountDao.selectAll(domain(vo))
            .stream()
            .map(this::vo)
            .collect(Collectors.toList());
    }

    @Override
    public int updateByPrimaryKeySelective(AccountVo vo) {
        return accountDao.updateByPrimaryKeySelective(domain(vo));
    }

    @Override
    public int updateByPrimaryKey(AccountVo vo) {
        return accountDao.updateByPrimaryKey(domain(vo));
    }

    private AccountVo vo(Account domain) {
        if (domain == null) {
            return null;
        }
        AccountVo vo = new AccountVo();
        BeanUtils.copyProperties(domain, vo);
        return vo;
    }

    private Account domain(AccountVo vo) {
        if (vo == null) {
            return null;
        }
        Account domain = new Account();
        BeanUtils.copyProperties(vo, domain);
        return domain;
    }
}
