package com.example.asyncthread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncServiceImpl implements AsyncService {

  @Async // 异步调用该方法
  @Override
  public void generateReport() {
    System.out.printf("报表线程名称：【%s】%n", Thread.currentThread().getName());
  }
}
