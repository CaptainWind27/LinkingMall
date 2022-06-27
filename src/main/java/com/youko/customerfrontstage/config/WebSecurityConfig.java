package com.youko.customerfrontstage.config;

import com.youko.customerfrontstage.service.CustomerService;
import com.youko.customerfrontstage.service.CustomerUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomerUserDetailService customerUserDetailService;

    /**密码加密使用bcrypt*/
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.
                userDetailsService(customerUserDetailService).
                passwordEncoder(passwordEncoder());
    }

    /**拦截请求*/
    @Override
    protected void configure(HttpSecurity httpSecurity)throws Exception{
        httpSecurity
                .authorizeRequests()
                //给authorizeRequests添加子方法为每个URL指定自定义要求
                //注册登陆界面所有用户都可以访问
                .antMatchers("/customer/register","/customer/login","/customer/profilePhotoUpload","/user/page").permitAll()
                .anyRequest().authenticated() // 所有请求都需要验证
                .and()
                .formLogin().disable()//关闭springsecurity默认登陆页
                .csrf().disable();/**post请求要关闭csrf验证不然报错，实际开发中开启*/
    }

//    /**测试端口用，放行所有请求*/
//    @Override
//    protected void configure(HttpSecurity httpSecurity)throws Exception{
//        httpSecurity.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
//
//    }


}
