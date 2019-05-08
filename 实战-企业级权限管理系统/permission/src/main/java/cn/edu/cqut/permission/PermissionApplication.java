package cn.edu.cqut.permission;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@MapperScan(basePackages = "cn.edu.cqut.permission.dao", annotationClass = Repository.class)
public class PermissionApplication {

  public static void main(String[] args) {
    SpringApplication.run(PermissionApplication.class, args);
  }
}
