package com.youko.customerfrontstage.web;

import com.youko.customerfrontstage.bean.Customer;
import com.youko.customerfrontstage.dto.customer.CustomerLoginDto;
import com.youko.customerfrontstage.dto.customer.CustomerLoginResponseDto;
import com.youko.customerfrontstage.dto.customer.CustomerRegisterDto;
import com.youko.customerfrontstage.dto.customer.ResponseDto;
import com.youko.customerfrontstage.service.CustomerService;
import com.youko.customerfrontstage.service.CustomerUserDetailService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;
import java.util.UUID;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${SavePath.ProfilePhoto}")
    private String ProfilePhotoSavePath;   //图标图片存储路径
    @Value("${SavePath.ProfilePhotoMapper}")
    private String ProfilePhotoMapperPath;   //图标映射路径


    /**注册接口*/
    @PostMapping("/customer/register")
    public ResponseDto saveCustomer(@RequestBody CustomerRegisterDto customerRegisterDto){
        ResponseDto responseDto=new ResponseDto();
        if(customerRegisterDto==null){
            responseDto.setMsg("注册信息缺失");
            responseDto.setStatus(0);
            return responseDto;
        }
        if(customerRegisterDto.getName()==null||customerRegisterDto.getPassword()==null){
            responseDto.setMsg("注册账号或密码缺失");
            responseDto.setStatus(0);
            return responseDto;
        }
        Customer customer=new Customer();
        customer.setName(customerRegisterDto.getName());
        customer.setPassword(passwordEncoder.encode(customerRegisterDto.getPassword()));
        customer.setMobile(customerRegisterDto.getMobile());
        customer.setRole("user");
        if (customerService.getCustomer(customerRegisterDto.getName())!=null){
            responseDto.setMsg("此账号重复");
            responseDto.setStatus(0);
            return responseDto;
        }
        customerService.saveCustomer(customer);
        responseDto.setMsg("注册成功");
        responseDto.setStatus(1);
        return responseDto;
    }


    /**登陆接口*/
    @PostMapping("/customer/login")
    public ResponseDto loginIn(@RequestBody CustomerLoginDto customerLoginDto){
        ResponseDto responseDto=new ResponseDto();
        CustomerLoginResponseDto customerLoginResponseDto=new CustomerLoginResponseDto();
        Customer customer= customerService.getCustomer(customerLoginDto.getName());
        if (customerLoginDto==null){
            responseDto.setMsg("登陆信息缺失");
            responseDto.setStatus(0);
            return responseDto;
        }
        if(customer==null){
            responseDto.setMsg("查无此号");
            /**
              12为为查找到的错误
             */
            responseDto.setStatus(12);
            return responseDto;
        }
        if (!passwordEncoder.matches(customerLoginDto.getPassword(),customer.getPassword())){
            responseDto.setMsg("密码错误");
            responseDto.setStatus(13);
            return responseDto;
        }
        customerLoginResponseDto.setMsg("登陆成功");
        customerLoginResponseDto.setStatus(1);
        customerLoginResponseDto.setId(customer.getId());
        customerLoginResponseDto.setName(customer.getName());
        customerLoginResponseDto.setNickname(customer.getNickname());
        customerLoginResponseDto.setPortrait(customer.getAvatar());
        return customerLoginResponseDto;
    }

    /**user访问权限*/
    @PreAuthorize("hasAnyRole('user')")
    @GetMapping("/customer/user")
    public String user(){
        return "user访问";
    }

    /**admin访问权限*/
    @PreAuthorize("hasAnyRole('admin')")
    @GetMapping("/customer/admin")
    public String admin(){
        return "admin访问";
    }


    /**修改密码接口*/

    @PutMapping ("/customer/updatePassword")
    public int updatePassword(@RequestBody String newPassword){
        return customerService.updatePassword(newPassword);
    }

    @PostMapping("/customer/profilePhotoUpload")
    public String profilePhotoUpload(@RequestParam int id,@RequestParam("file") MultipartFile fileUpload){
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        //获取文件后缀名。也可以在这里添加判断语句，规定特定格式的图片才能上传，否则拒绝保存。
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //为了避免发生图片替换，这里使用了文件名重新生成
        fileName = UUID.randomUUID()+suffixName;
        try {
            //将图片保存到文件夹里
            fileUpload.transferTo(new File(ProfilePhotoSavePath+fileName));
            customerService.updateCustomerPhotoPath(id,ProfilePhotoMapperPath+fileName);
            return ProfilePhotoMapperPath+fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
