package com.youko.customerfrontstage.config;


import com.google.gson.Gson;
import com.youko.customerfrontstage.dto.customer.ResponseDto;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 无权限用户访问异常
 */
@Component
public class CustomerAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        response.setContentType("text/json;charset=utf-8");
        ResponseDto responseDto=new ResponseDto();
        responseDto.setStatus(0);
        responseDto.setMsg("无访问权限");
        response.getWriter().write(new Gson().toJson(responseDto));

    }
}
