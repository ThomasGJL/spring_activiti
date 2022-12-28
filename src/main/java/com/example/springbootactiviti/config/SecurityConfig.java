package com.example.springbootactiviti.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    LoginSuccessHandle successHandle;

    @Autowired
    LoginFailHandle failHandle;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginProcessingUrl("/login")
                // 配置登录成功处理器
                .successHandler(successHandle)
                // 配置登录失败处理器
                .failureHandler(failHandle)
                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/**").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout().permitAll().and()
                .headers().frameOptions().disable()//让frame页面可以正常使用
                .and()
                // 配置自定义鉴权失败端点
                .exceptionHandling().authenticationEntryPoint(new AuthEntryPoint())
                .and()
                .csrf().disable();
    }
}
