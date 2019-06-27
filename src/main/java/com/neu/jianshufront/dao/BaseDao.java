package com.neu.jianshufront.dao;

import org.hibernate.validator.constraints.EAN;

import java.util.List;

public interface BaseDao<T> {
    List<T> getList();
    T get(int id);
    int update(T t);
    int delete(int id);
    int add(T t);
}
