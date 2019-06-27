package com.neu.jianshufront.service.impl;

import com.neu.jianshufront.dao.UserActionDao;
import com.neu.jianshufront.entity.UserAction;
import com.neu.jianshufront.service.UserActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class UserActionServiceImpl implements UserActionService {

    @Autowired
    private UserActionDao userActionDao;

    @Override
    public int addUserAction(UserAction userAction) {
        if(StringUtils.isEmpty(userAction.getUid().trim())|| StringUtils.isEmpty(userAction.getAction().trim())
        ||StringUtils.isEmpty(userAction.getPid())){
            return -1;
        }
        return userActionDao.add(userAction);
    }

    @Override
    public int deleteUserAction(int id) {
        return userActionDao.delete(id);
    }

    @Override
    public List<UserAction> getUserActionByUserId(String userId) {
        return userActionDao.getUserActionByUser(userId);
    }
}
