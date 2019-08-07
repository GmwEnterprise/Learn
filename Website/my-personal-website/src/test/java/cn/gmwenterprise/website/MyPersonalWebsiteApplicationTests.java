package cn.gmwenterprise.website;

import cn.gmwenterprise.website.dao.AccountDao;
import cn.gmwenterprise.website.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyPersonalWebsiteApplicationTests {

    @Resource
    AccountDao accountDao;

    @Test
    public void contextLoads() {
        List<Account> accounts1 = accountDao.selectAll(new Account());
        assert accounts1 != null;

        Account account = accountDao.selectByPrimaryKey(1);
        System.out.println(account != null);
    }

}
