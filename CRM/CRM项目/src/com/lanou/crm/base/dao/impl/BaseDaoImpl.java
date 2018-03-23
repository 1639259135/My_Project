package com.lanou.crm.base.dao.impl;

import com.lanou.crm.base.dao.BaseDao;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    private final Class<T> daoClass;

    public BaseDaoImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        daoClass = (Class<T>) type.getActualTypeArguments()[0];
    }

    @Override
    public List<T> queryAll() {
        List<T> list = (List<T>) this.getHibernateTemplate().find("from " + daoClass.getName());
        return list;
    }

    @Override
    public List<T> limitQuery(int begin, int end) {
        List<T> byExample = this.getHibernateTemplate().findByExample((T) daoClass, begin, (end - begin));
        return byExample;
    }

    @Override
    public int queryAllCount() {
        Object count = this.getHibernateTemplate().find(
                "select count(*) from" + daoClass.getName()).listIterator().next();
        return (int) Long.valueOf(count.toString()).longValue();
    }

    @Override
    public T queryById(String id) {
        return this.getHibernateTemplate().get(daoClass, id);
    }

    @Override
    public void add(T t) {
        this.getHibernateTemplate().save(t);
    }

    @Override
    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    @Override
    public void saveOrUpdate(T t) {
        this.getHibernateTemplate().saveOrUpdate(t);
    }

    @Override
    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }

    @Override
    public List<T> queryByCondition(String condition, Object... params) {
        String hql = "from " + daoClass.getName() + " where 1=1 " ;
        List<T> list = (List<T>) this.getHibernateTemplate().find(hql);
        return list;
    }
}
