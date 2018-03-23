package com.lanou.crm.utils;

import com.lanou.crm.paging.domain.Page;
import com.opensymphony.xwork2.ActionContext;

public class PageUtil {

    public interface ResultHandle{
        void resultPage(int begin, int end);
    }

    public static void handle(Page page, int totalData, ResultHandle rh) {
        page.setTotalData(totalData);
        int begin = (page.getPageCode() - 1) * page.getPageSize();
        int end;
        if (page.getTotalData() - begin > page.getPageSize()){
            end = page.getPageCode() * page.getPageSize();
        }else {
            end = page.getTotalData();
        }
        rh.resultPage(begin, end);
        ActionContext.getContext().getSession().put("page", page);
    }


}
