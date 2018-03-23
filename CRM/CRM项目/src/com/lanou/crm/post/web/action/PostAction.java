package com.lanou.crm.post.web.action;

import com.lanou.crm.post.domain.CrmPost;
import com.lanou.crm.post.service.PostService;
import com.lanou.crm.post.service.impl.PostServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.List;

public class PostAction extends ActionSupport {

    private PostService postService;
    private CrmPost post;

    public String queryPostByDepId() throws IOException {
//        String depId = ServletActionContext.getRequest().getParameter("depId");
        System.out.println(post.getCrmDepartment());
        List<CrmPost> postByDepId = postService.queryPostByDepId(post.getCrmDepartment());
        System.out.println(postByDepId);

        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"crmDepartment","staffSet"});
        JSONArray jsonArray = JSONArray.fromObject(postByDepId,jsonConfig);
        String str = jsonArray.toString();
        System.out.println(str);
        ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().write(str);

        return NONE;
    }






    public void setPostService(PostServiceImpl postService) {
        this.postService = postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public void setPost(CrmPost post) {
        this.post = post;
    }

    public CrmPost getPost() {
        return post;
    }
}
