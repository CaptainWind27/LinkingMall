package com.youko.customerfrontstage.mapper;

import com.youko.customerfrontstage.bean.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper {
    Customer sel(int id);
}
