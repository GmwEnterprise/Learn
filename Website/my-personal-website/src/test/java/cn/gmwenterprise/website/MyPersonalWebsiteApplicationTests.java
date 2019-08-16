package cn.gmwenterprise.website;

import cn.gmwenterprise.website.config.mybatis.Page;
import cn.gmwenterprise.website.config.mybatis.PageHelper;
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
    }

}
