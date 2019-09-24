package com.example.learn.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

@Slf4j
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Resource(name = "jacksonObjectMapper")
    private ObjectMapper objectMapper;

    @Resource(name = "jwtAuthenticationTokenFilter")
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Resource
    private UserMessageStorage userMessageStorage;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new AuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                String username = (String) authentication.getPrincipal();
                String password = (String) authentication.getCredentials();
                String defaultUsername = "gmw", defaultPassword = "123";
                if (defaultUsername.equals(username) && defaultPassword.equals(password)) {
                    List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList("ROLE_USER");
                    return new UsernamePasswordAuthenticationToken(username, password, authorityList);
                }
                throw new BadCredentialsException("密码错误");
            }

            @Override
            public boolean supports(Class<?> authentication) {
                return true;
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // 禁止csrf，restful不需要
            .csrf().disable()

            // 禁用session，restful无状态
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

            // 添加自定义验证过滤器
            .and().addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)

            // 接口权限定义
            .authorizeRequests().anyRequest().authenticated()

            // 鉴权异常处理
            .and().exceptionHandling()

            // 需要登录
            .authenticationEntryPoint((request, response, error) -> getWriter(response)
                .write(objectMapper.writeValueAsString(ResultEntity.pack(1, "游客无权访问", error.getMessage()))))

            // 无权访问
            .accessDeniedHandler(((request, response, error) -> getWriter(response)
                .write(objectMapper.writeValueAsString(ResultEntity.pack(1, "无权访问", error.getMessage())))))

            // 开启表单登录
            .and().formLogin().loginProcessingUrl("/log").permitAll()

            // 登录成功
            .successHandler((request, response, auth) -> {
                String token = UUID.randomUUID().toString();
                userMessageStorage.set(token, auth);
                ResultEntity<String> successResult = ResultEntity.pack(0, "success", token);
                getWriter(response).write(objectMapper.writeValueAsString(successResult));
            })

            // 登录失败
            .failureHandler((request, response, error) -> getWriter(response)
                .write(objectMapper.writeValueAsString(ResultEntity.pack(1, error.getMessage(), error.getMessage()))))

            .and().logout()
            .addLogoutHandler((request, response, authentication) -> {
                log.info("add log handler");
                // TODO
            });
    }

    private PrintWriter getWriter(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        return response.getWriter();
    }
}
