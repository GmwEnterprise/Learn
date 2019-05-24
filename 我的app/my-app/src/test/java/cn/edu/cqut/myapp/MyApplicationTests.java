package cn.edu.cqut.myapp;

import cn.edu.cqut.myapp.service.AppUserService;
import cn.edu.cqut.myapp.util.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyApplicationTests {

  @Autowired
  AppUserService appUserService;

  @Autowired
  RedisUtils redisUtils;

  @Test
  public void contextLoads() {

  }
}
