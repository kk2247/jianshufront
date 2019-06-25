package com.neu.jianshufront.service.impl;

import com.neu.jianshufront.dao.KeyWordDao;
import com.neu.jianshufront.entity.KeyWord;
import com.neu.jianshufront.service.SearchService;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.library.DicLibrary;
import org.ansj.splitWord.analysis.DicAnalysis;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SearchServiceImpl implements SearchService {

    @Autowired
    private KeyWordDao keyWordDao;

//    初始化分词系统
    public SearchServiceImpl() {
        DicLibrary.insert(DicLibrary.DEFAULT,"");
    }
    @Override
    public List<KeyWord> getLink(String line) {
        Result result = DicAnalysis.parse(line.trim());
        List<Term> terms = result.getTerms();
        List<KeyWord> keyWords=new ArrayList<>();
        for(int i =0 ;i<terms.size();i++){
            String word = terms.get(i).getName().trim();
            if(word.equals("")){
                keyWords.addAll(keyWordDao.getLinkByKeyWord(word));
            }
        }
        return keyWords;
    }
}
