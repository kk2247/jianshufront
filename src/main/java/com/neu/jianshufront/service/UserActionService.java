package com.neu.jianshufront.service;

import com.neu.jianshufront.entity.UserAction;

import java.util.List;

public interface UserActionService {
    int addUserAction(UserAction userAction);
    int deleteUserAction(int id);
    List<UserAction> getUserActionByUserId(String userId);

}
