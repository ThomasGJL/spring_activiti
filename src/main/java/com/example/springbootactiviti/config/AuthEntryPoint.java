package com.example.springbootactiviti.config;

import com.example.springbootactiviti.common.BaseResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检测到未登录的时候，这里返回json的应答，而不是跳转到登录页面
 */
public class AuthEntryPoint implements AuthenticationEntryPoint {

    public static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        BaseResponse<Void> response = new BaseResponse<>(401, "请先登录系统");
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(response));
    }
}

