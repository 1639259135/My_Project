package com.lanou.springbootwyj.mapper;

import com.lanou.springbootwyj.domain.Comment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {

    @Select("select * from store_comment where store_id = #{id}")
    List<Comment> selectCommentById(@Param("id") int id);


}
