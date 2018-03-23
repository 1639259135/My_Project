package com.lanou.crm.post.service.impl;

import com.lanou.crm.department.domain.CrmDepartment;
import com.lanou.crm.post.dao.PostDao;
import com.lanou.crm.post.dao.impl.PostDaoImpl;
import com.lanou.crm.post.domain.CrmPost;
import com.lanou.crm.post.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {
    private PostDao postDao;

    @Override
    public List<CrmPost> queryPostByDepId(CrmDepartment department) {
        return postDao.queryPostByDepId(department);
    }








    public void setPostDao(PostDaoImpl postDao) {
        this.postDao = postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
