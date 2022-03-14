package org.selina.ptj.bean;

import java.util.List;

/**
 * @ Author : Selina
 * @ Date : 2020/4/10
 * @ Description : org.selina.ptj.bean
 * @ version : 1.0
 * 此类用来保存分页查询的结果
 */

public class RespPageBean {
    //当前要展示的数据、多少页
    private Long total;
    private List<?> data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
