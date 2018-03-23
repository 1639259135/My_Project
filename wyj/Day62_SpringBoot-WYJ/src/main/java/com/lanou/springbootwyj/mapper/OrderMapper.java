package com.lanou.springbootwyj.mapper;

import com.lanou.springbootwyj.domain.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    @Insert("insert into `order`(aname,acount,price,uid,count) values(#{aname},#{acount},#{price},#{uid},#{count})")
    boolean insertOrder(Order order);

    @Select("select * from `order` where uid = #{uid}")
    List<Order> selectOrderByUid(int uid);

    @Delete("delete from `order` where oid = #{oid}")
    boolean remove(int odi);

    @Update("update `order` set count = #{count} where oid = #{oid}")
    boolean updataOrder(@Param("oid") int oid,@Param("count") int count);

}
