package com.neu.jianshufront.service.impl;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import com.neu.jianshufront.dao.KeyWordDao;
import com.neu.jianshufront.entity.KeyWord;
import com.neu.jianshufront.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private KeyWordDao keyWordDao;

    @Override
    public List<KeyWord> getLink(String line) {
        List<KeyWord> keyWords=new ArrayList<>();
        JiebaSegmenter segmenter = new JiebaSegmenter();
        if(line.trim().length()>2){
            List<SegToken> list = segmenter.process(line, JiebaSegmenter.SegMode.SEARCH);
            for(SegToken segToken:list){
                keyWords.addAll(keyWordDao.getLinkByKeyWord(segToken.word.trim()));
            }
        }else{
            keyWords.addAll(keyWordDao.getLinkByKeyWord(line.trim()));
        }
        return keyWords;
    }

    @Override
    public List<KeyWord> getCollectByUserId(int userId) {
        return keyWordDao.getArticleInCollect(userId);
    }
}
