package com.lanou.crm.post.service;

import com.lanou.crm.department.domain.CrmDepartment;
import com.lanou.crm.post.domain.CrmPost;

import java.util.List;

public interface PostService {

    List<CrmPost> queryPostByDepId(CrmDepartment department);


}
