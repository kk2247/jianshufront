package com.neu.jianshufront.controller;


import com.neu.jianshufront.service.SearchService;
import com.neu.jianshufront.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/index")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping("search")
    @Transactional
    public Message search(@RequestParam("line") String line){
        Message message=new Message();

        return message;
    }
}
