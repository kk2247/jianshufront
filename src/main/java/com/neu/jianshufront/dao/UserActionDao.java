package com.neu.jianshufront.dao;

import com.neu.jianshufront.entity.UserAction;

import java.util.List;

public interface UserActionDao extends BaseDao<UserAction> {
    List<UserAction> getUserActionByUser(String uid);
    UserAction check(UserAction userAction);
}
