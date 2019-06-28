package com.neu.jianshufront.service.impl;

import com.neu.jianshufront.dao.MyUserDao;
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

    @Autowired
    private MyUserDao myUserDao;

    @Override
    public int addUserAction(UserAction userAction) {
        if(StringUtils.isEmpty(userAction.getUid().trim())|| StringUtils.isEmpty(userAction.getAction().trim())
        ||StringUtils.isEmpty(userAction.getPid())){
            return -1;
        }
        if(userAction.getAction().equals("collect")){
            UserAction userAction1=userActionDao.check(userAction);
            if(userAction1==null){
                myUserDao.addCollect(Integer.parseInt(userAction.getUid()));
                return userActionDao.add(userAction);
            }else{
                myUserDao.deleteCollect(Integer.parseInt(userAction.getUid()));
                return userActionDao.delete(userAction1.getId());
            }
        }else{
            UserAction userAction1=userActionDao.check(userAction);
            if(userAction1==null){
                return userActionDao.add(userAction);
            }else {
                return 0;
            }
        }
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
