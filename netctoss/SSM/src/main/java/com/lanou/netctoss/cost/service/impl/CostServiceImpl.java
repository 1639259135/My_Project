package com.lanou.netctoss.cost.service.impl;

import com.lanou.netctoss.cost.dao.CostMapper;
import com.lanou.netctoss.cost.domain.Cost;
import com.lanou.netctoss.cost.domain.CostPage;
import com.lanou.netctoss.cost.service.CostService;
import com.lanou.netctoss.base.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CostServiceImpl implements CostService {

    @Resource
    private CostMapper costMapper;

    public CostPage findCost(CostPage page) {
        page.setPageSize(6);
        page.setTotalData(costMapper.findCount());
        List<Cost> costList = costMapper.findByLimit(page);
        page.setCostList(costList);
        return page;
    }

    public String addCost(Cost cost) {
        Cost c = costMapper.findByName(cost.getName());
        if (c != null){
            return null;
        }
        int maxId = costMapper.findMaxId();
        cost.setId(maxId + 1);
        cost.setStatus("0");
        return costMapper.insert(cost) + "";
    }

    public Cost findById(int id){
        return costMapper.selectByPrimaryKey(id);
    }

    public void updateCost(Cost cost) {
        Date date = new Date();
        cost.setStartime(date);
        cost.setStatus("1");
        costMapper.updateByPrimaryKeySelective(cost);
    }

    public void deleteCost(int id) {
        costMapper.deleteByPrimaryKey(id);
    }
}
