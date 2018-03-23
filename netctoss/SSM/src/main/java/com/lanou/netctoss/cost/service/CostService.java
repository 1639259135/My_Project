package com.lanou.netctoss.cost.service;

import com.lanou.netctoss.cost.domain.Cost;
import com.lanou.netctoss.base.Page;
import com.lanou.netctoss.cost.domain.CostPage;


public interface CostService {

    CostPage findCost(CostPage page);

    String addCost(Cost cost);

    Cost findById(int id);

    void updateCost(Cost cost);

    void deleteCost(int id);

}
