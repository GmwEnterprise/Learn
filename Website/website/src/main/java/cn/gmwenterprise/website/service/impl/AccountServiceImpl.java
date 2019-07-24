package cn.gmwenterprise.website.service.impl;

import cn.gmwenterprise.website.bo.AccountBo;
import cn.gmwenterprise.website.dao.AccountDao;
import cn.gmwenterprise.website.po.Account;
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
    public int insert(AccountBo bo) {
        return accountDao.insert(po(bo));
    }
    
    @Override
    public int insertSelective(AccountBo bo) {
        return accountDao.insertSelective(po(bo));
    }
    
    @Override
    public AccountBo selectByPrimaryKey(Integer id) {
        return bo(accountDao.selectByPrimaryKey(id));
    }
    
    @Override
    public List<AccountBo> selectAll(AccountBo bo) {
        return accountDao.selectAll(po(bo))
            .stream()
            .map(this::bo)
            .collect(Collectors.toList());
    }

    @Override
    public int updateByPrimaryKeySelective(AccountBo bo) {
        return accountDao.updateByPrimaryKeySelective(po(bo));
    }

    @Override
    public int updateByPrimaryKey(AccountBo bo) {
        return accountDao.updateByPrimaryKey(po(bo));
    }

    private AccountBo bo(Account po) {
        if (po == null) {
            return null;
        }
        AccountBo bo = new AccountBo();
        BeanUtils.copyProperties(po, bo);
        return bo;
    }

    private Account po(AccountBo bo) {
        if (bo == null) {
            return null;
        }
        Account po = new Account();
        BeanUtils.copyProperties(bo, po);
        return po;
    }
}
