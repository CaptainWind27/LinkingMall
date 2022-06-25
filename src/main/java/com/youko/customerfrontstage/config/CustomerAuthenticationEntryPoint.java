package com.youko.customerfrontstage.config;

import com.google.gson.Gson;
import com.youko.customerfrontstage.bean.ReturnPojo;
import net.minidev.json.JSONArray;
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
        ReturnPojo returnPojo = new ReturnPojo();
        returnPojo.setReInt(10);
        returnPojo.setReString("无访问权限");
        response.getWriter().write(new Gson().toJson(returnPojo));

    }
}
