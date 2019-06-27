package com.neu.jianshufront.dao;

import com.neu.jianshufront.entity.KeyWord;
import org.ansj.app.keyword.Keyword;

import java.util.List;

public interface KeyWordDao extends BaseDao<Keyword> {
    List<KeyWord> getLinkByKeyWord(String keyWord);
}
