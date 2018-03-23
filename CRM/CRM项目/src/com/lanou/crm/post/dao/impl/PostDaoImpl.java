package com.lanou.crm.post.dao.impl;

import com.lanou.crm.department.domain.CrmDepartment;
import com.lanou.crm.post.dao.PostDao;
import com.lanou.crm.post.domain.CrmPost;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class PostDaoImpl extends HibernateDaoSupport implements PostDao {

    private String sql = "";

    @Override
    public List<CrmPost> queryPostByDepId(CrmDepartment department) {
        sql = "from CrmPost where crmDepartment=?";
        List<CrmPost> list = (List<CrmPost>) this.getHibernateTemplate().find(sql, department);
        return list;
    }
}
