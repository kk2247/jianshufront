package com.neu.jianshufront.service.impl;

import com.neu.jianshufront.dao.MyUserDao;
import com.neu.jianshufront.entity.MyUser;
import com.neu.jianshufront.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

@Service
public class MyUserServiceImpl implements MyUserService {

    @Autowired
    private MyUserDao myUserDao;

    private final String slat="jkslfoijvniolerjgkdsjghjgsihngjlk#$%";
    @Override
    public MyUser login(String email, String password) {
        password=getMD5(password);
        return myUserDao.getUserByEmailAndPassword(email,password);
    }

    @Transactional( rollbackFor = Exception.class)
    @Override
    public int register(MyUser user) {
        user.setPassword(getMD5(user.getPassword()));
        int id=myUserDao.add(user);
        if(id>0){
            id=user.getId();
        }
        return id;
    }

    private String getMD5(String password){
        String base=password+"/"+slat;
        String md5= DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
}
