package com.lanou.netctoss.cost.domain;

import com.lanou.netctoss.base.Page;

import java.util.List;

public class CostPage extends Page {

    private List<Cost> costList;

    public CostPage() {
    }

    @Override
    public String toString() {
        return "CostPage{" + "costList=" + costList + '}';
    }

    public List<Cost> getCostList() {
        return costList;
    }

    public void setCostList(List<Cost> costList) {
        this.costList = costList;
    }


}
