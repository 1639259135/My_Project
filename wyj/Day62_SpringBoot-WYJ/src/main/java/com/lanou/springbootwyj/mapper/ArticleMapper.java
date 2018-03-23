package com.lanou.springbootwyj.mapper;

import com.lanou.springbootwyj.domain.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {

    @Select("select * from article")
    List<Article> findArticles();

    @Select("select * from article limit #{page},#{PAGE_SIZE}")
    List<Article> findArticleByHot(@Param("page") int page, @Param("PAGE_SIZE") int PAGE_SIZE);

    @Select("select * from article where type = #{type}")
    List<Article> selectByType(@Param("type") String type);

    @Select("select * from article where goods_id = #{id}")
    List<Article> selectById(@Param("id") int id);


}
