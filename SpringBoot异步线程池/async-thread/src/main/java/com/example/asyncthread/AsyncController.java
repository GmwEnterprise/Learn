package com.example.asyncthread;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

  private final AsyncService asyncService;

  public AsyncController(AsyncService asyncService) {
    this.asyncService = asyncService;
  }

  @GetMapping("/async")
  public String useAsync() {
    System.out.printf("请求线程名称：【%s】%n", Thread.currentThread().getName());
    asyncService.generateReport();
    return "success";
  }
}
