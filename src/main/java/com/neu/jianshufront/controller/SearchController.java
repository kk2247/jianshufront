package com.neu.jianshufront.controller;


import com.neu.jianshufront.entity.KeyWord;
import com.neu.jianshufront.service.SearchService;
import com.neu.jianshufront.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/index")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping("search")
    @Transactional
    @ResponseBody
    public Message search(@RequestParam("line") String line){
        Message message=new Message();
        List<KeyWord> wordList = searchService.getLink(line);
        message.ok(HttpStatus.ACCEPTED,"请求成功").addData("data",wordList);
        return message;
    }
}
