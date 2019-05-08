package cn.edu.cqut.permission.web;

import cn.edu.cqut.permission.common.JsonData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

  @GetMapping("/hello.page")
  public JsonData hello() {
    log.info("hello");
    // return JsonData.success("hello, permission");
    throw new RuntimeException();
  }
}
