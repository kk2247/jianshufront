package com.neu.jianshufront.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import com.neu.jianshufront.dao.KeyWordDao;
import com.neu.jianshufront.entity.KeyWord;
import com.neu.jianshufront.service.SearchService;
import com.neu.jianshufront.util.HttpApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private KeyWordDao keyWordDao;

    private HttpApi api;

    @Override
    public List<KeyWord> getLink(String line) {
        List<KeyWord> keyWords=new ArrayList<>();
        JiebaSegmenter segmenter = new JiebaSegmenter();
        if(line.trim().length()>2){
            List<SegToken> list = segmenter.process(line, JiebaSegmenter.SegMode.SEARCH);
            for(SegToken segToken:list){
                try {
                    keyWords.addAll(keyWordDao.getLinkByKeyWord(segToken.word.trim()));
//                    String result= "{\"res\": [{\"key\": \"小说\", \"val\": \"1.0\"}, {\"key\": \"短篇小说\", \"val\": \"0.8290216\"}, {\"key\": \"长篇小说\", \"val\": \"0.78992206\"}, {\"key\": \"小说作品\", \"val\": \"0.76810753\"}, {\"key\": \"科幻小说\", \"val\": \"0.76467204\"}, {\"key\": \"历史小说\", \"val\": \"0.7544195\"}, {\"key\": \"系列小说\", \"val\": \"0.7525812\"}, {\"key\": \"作品\", \"val\": \"0.7412416\"}, {\"key\": \"畅销小说\", \"val\": \"0.726908\"}, {\"key\": \"侦探小说\", \"val\": \"0.7157542\"}]}\n";
                    String result=api.getMessage("");
                    JSONArray data=getJsonData(result);
                    for (int i=0;i<data.size();i++){
                        JSONObject object= (JSONObject) data.get(i);
                        String key= (String) object.get("key");
                        String value= (String) object.get("val");
                        keyWords.addAll(keyWordDao.getLinkByKeyWord(key.trim()));
//                        System.out.println(key);
//                        System.out.println(value);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else{
            keyWords.addAll(keyWordDao.getLinkByKeyWord(line.trim()));
        }
        return keyWords;
    }

    public JSONArray getJsonData(String line){
        JSONObject parse = (JSONObject) JSONArray.parse(line);
        JSONArray array= parse.getJSONArray("res");
        return array;
    }

    @Override
    public List<KeyWord> getCollectByUserId(int userId,String category) {
        return keyWordDao.getArticleInCollect(userId,category);
    }
}
