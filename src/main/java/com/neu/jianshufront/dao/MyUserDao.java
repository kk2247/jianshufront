package com.neu.jianshufront.dao;

import com.neu.jianshufront.entity.MyUser;

public interface MyUserDao extends BaseDao<MyUser> {

    MyUser getUserByEmailAndPassword(String email,String password);
    int addCollect(int id);
    int deleteCollect(int id);
}
