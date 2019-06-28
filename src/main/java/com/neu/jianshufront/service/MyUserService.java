package com.neu.jianshufront.service;

import com.neu.jianshufront.entity.MyUser;

public interface MyUserService {
    MyUser login(String email,String password);
    int register(MyUser user);
}
