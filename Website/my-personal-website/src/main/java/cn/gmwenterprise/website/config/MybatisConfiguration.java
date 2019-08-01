package cn.gmwenterprise.website.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

@Configuration
@MapperScan(basePackages = "cn.gmwenterprise.website.dao", annotationClass = Repository.class)
public class MybatisConfiguration {
}
