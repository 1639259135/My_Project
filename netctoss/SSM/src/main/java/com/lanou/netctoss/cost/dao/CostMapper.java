package com.lanou.netctoss.cost.dao;

import com.lanou.netctoss.cost.domain.Cost;
import com.lanou.netctoss.base.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Cost record);

    int insertSelective(Cost record);

    Cost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cost record);

    int updateByPrimaryKey(Cost record);

    List<Cost> findByLimit(Page page);

    Cost findByName(String name);

    int findMaxId();

    int findCount();


}