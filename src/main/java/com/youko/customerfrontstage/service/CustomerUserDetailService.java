package com.youko.customerfrontstage.service;

import com.youko.customerfrontstage.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerUserDetailService implements UserDetailsService {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer=customerService.getCustomer(username);
        if (customer==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        String role=customer.getRole();

        List<GrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
        return new User(customer.getName(),customer.getPassword(),authorities);
    }
}
