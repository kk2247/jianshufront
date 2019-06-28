package com.neu.jianshufront.controller;


import com.neu.jianshufront.entity.UserAction;
import com.neu.jianshufront.service.UserActionService;
import com.neu.jianshufront.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/action")
public class ActionController {

    @Autowired
    private UserActionService userActionService;

    @RequestMapping("/collect")
    @ResponseBody
    @Transactional
    public Message collect(@RequestParam("uid")String uid,
                           @RequestParam("pid")String pid){
        Message message=new Message();
        UserAction userAction=new UserAction();
        userAction.setUid(uid.trim());
        userAction.setPid(pid.trim());
        userAction.setAction("collect");
        userAction.setTime(String.valueOf(new Date()));
        int flag=userActionService.addUserAction(userAction);
        if(flag<0){
            message.ok(HttpStatus.BAD_REQUEST,"文章收藏失败");
        }else{
            message.ok(HttpStatus.OK,"文章收藏成功");
        }
        return message;
    }

    @RequestMapping("/browse")
    @ResponseBody
    @Transactional
    public Message browse(@RequestParam("uid")String uid,
                          @RequestParam("pid")String pid){
        Message message=new Message();
        UserAction userAction=new UserAction();
        userAction.setUid(uid.trim());
        userAction.setPid(pid.trim());
        userAction.setAction("browse");
        Date currentTime = new Date();// 获取当前时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");// 格式化时间
        String dateString = formatter.format(currentTime);
        userAction.setTime(dateString);
        int flag=userActionService.addUserAction(userAction);
        if(flag<0){
            message.ok(HttpStatus.BAD_REQUEST,"文章浏览计数失败");
        }else{
            message.ok(HttpStatus.OK,"文章浏览计数成功");
        }
        return message;
    }

    @RequestMapping("/getbyuser")
    @ResponseBody
    @Transactional
    public Message getByUser(@RequestParam("uid")String uid){
        Message message=new Message();
        List<UserAction> userActions=userActionService.getUserActionByUserId(uid);
        if(userActions.size()==0){
            message.ok(HttpStatus.BAD_REQUEST,"用户没有相关数据");
        }else{
            message.ok(HttpStatus.OK,"成功获得数据").addData("data",userActions);
        }
        return message;
    }

    @RequestMapping("delete")
    @ResponseBody
    @Transactional
    public Message delete(@RequestParam("id")int id){
        Message message=new Message();
        int flag=userActionService.deleteUserAction(id);
        if(id<0){
            message.ok(HttpStatus.BAD_REQUEST,"删除收藏失败");
        }else{
            message.ok(HttpStatus.OK,"成功删除收藏文章");
        }
        return message;
    }
}
