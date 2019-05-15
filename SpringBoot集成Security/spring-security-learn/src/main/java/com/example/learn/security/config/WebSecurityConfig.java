package com.example.learn.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // 密码编码器
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder>
        userConfig = auth.inMemoryAuthentication().passwordEncoder(passwordEncoder);
    userConfig.withUser("admin")
        .password(passwordEncoder.encode("abc"))
        .authorities("ROLE_USER", "ROLE_ADMIN");
    userConfig.withUser("myUser")
        .password(passwordEncoder.encode("123456"))
        .authorities("ROLE_USER");
  }
}
