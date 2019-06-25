package com.neu.jianshufront.dao;

import com.neu.jianshufront.entity.KeyWord;

import java.util.List;

public interface KeyWordDao {
    List<KeyWord> getLinkByKeyWord(String keyWord);
}
