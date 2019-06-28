package com.neu.jianshufront.service;


import com.neu.jianshufront.entity.KeyWord;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SearchService {
    List<KeyWord> getLink(String line);
    List<KeyWord> getCollectByUserId(int userId);
}
