package com.lanou.crm.base.dao;

import java.util.List;

public interface BaseDao<T> {

    List<T> queryAll();

    List<T> limitQuery(int begin, int end);

    int queryAllCount();

    T queryById(String id);

    void add(T t);

    void update(T t);

    void saveOrUpdate(T t);

    void delete(T t);

    List<T> queryByCondition(String condition,Object...params);

}
