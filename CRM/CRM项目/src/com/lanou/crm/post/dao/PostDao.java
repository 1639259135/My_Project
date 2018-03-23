package com.lanou.crm.post.dao;

import com.lanou.crm.department.domain.CrmDepartment;
import com.lanou.crm.post.domain.CrmPost;

import java.util.List;

public interface PostDao {

    List<CrmPost> queryPostByDepId(CrmDepartment department);

}
