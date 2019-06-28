package com.neu.jianshufront.controller;

import com.neu.jianshufront.entity.MyUser;
import com.neu.jianshufront.service.MyUserService;
import com.neu.jianshufront.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MyUserService myUserService;

    @RequestMapping("/login")
    @ResponseBody
    public Message login(@RequestParam("email")String email,@RequestParam("password")String password){
        Message message =new Message();
        MyUser user=myUserService.login(email,password);
        if(user==null){
            message.ok(HttpStatus.BAD_REQUEST,"输入账号或者密码错误");
        }else{
            message.ok(HttpStatus.OK,"登录成功").addData("user",user);
        }
        return message;
    }

    @PostMapping("/register")
    @ResponseBody
    public Message register(@RequestParam("email")String email,@RequestParam("password")String password,
                            @RequestParam("account")String account){
        Message message=new Message();
        if(StringUtils.isEmpty(email) ||StringUtils.isEmpty(password)||StringUtils.isEmpty(account) ){
            message.ok(HttpStatus.FORBIDDEN,"输入内容不能为空");
        }else{
            MyUser user=new MyUser();
            user.setPassword(password);
            user.setAccount(account);
            user.setEmail(email);
            int id=myUserService.register(user);
            if(id>0){
                message.ok(HttpStatus.OK,"注册成功");
            }else{
                message.ok(HttpStatus.BAD_REQUEST,"注册失败");
            }
        }
        return message;
    }
}
