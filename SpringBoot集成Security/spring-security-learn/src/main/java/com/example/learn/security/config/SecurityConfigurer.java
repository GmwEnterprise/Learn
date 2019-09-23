package com.example.learn.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Resource(name = "jacksonObjectMapper")
    private ObjectMapper objectMapper;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new AuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                System.out.println("authenticate !");
                String username = (String) authentication.getPrincipal();
                String password = (String) authentication.getCredentials();
                String defaultUsername = "gmw", defaultPassword = "123";
                if (defaultUsername.equals(username) && defaultPassword.equals(password)) {
                    return authentication;
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
        http.csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().authorizeRequests().anyRequest().authenticated()
            .and().exceptionHandling()
            .authenticationEntryPoint((request, response, error) -> getWriter(response)
                .write(objectMapper.writeValueAsString(ResultEntity.pack(1, "游客无权访问", error.getMessage()))))
            .accessDeniedHandler(((request, response, error) -> getWriter(response)
                .write(objectMapper.writeValueAsString(ResultEntity.pack(1, "无权访问", error.getMessage())))))
            .and()
            .formLogin().loginProcessingUrl("/log").permitAll()
            .successHandler((request, response, auth) -> getWriter(response)
                .write(objectMapper.writeValueAsString(ResultEntity.pack(0, "success", auth))))
            .failureHandler((request, response, error) -> getWriter(response)
                .write(objectMapper.writeValueAsString(ResultEntity.pack(1, error.getMessage(), error.getMessage()))));
    }

    private PrintWriter getWriter(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        return response.getWriter();
    }
}
