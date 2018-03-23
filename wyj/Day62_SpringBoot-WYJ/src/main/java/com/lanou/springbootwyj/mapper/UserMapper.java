package com.lanou.springbootwyj.mapper;

import com.lanou.springbootwyj.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Select("select * from basic_user where phone = #{phone} and password = #{password}")
    User selectUserByLogin(User user);

    @Select("select * from basic_user where phone = #{phone}")
    User findUserByPhone(@Param("phone") String phone);

    @Select("select * from basic_user where user_name = #{user_name}")
    User selectUser(User user);

    @Insert("insert into basic_user(user_name,password,phone) values(#{user_name},#{password},#{phone})")
    void insertUser(User user);



}
