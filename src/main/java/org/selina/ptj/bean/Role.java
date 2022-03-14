package org.selina.ptj.bean;

import java.io.Serializable;

/**
 * @ Author : Selina
 * @ Date : 2020/4/7
 * @ Description : org.selina.ptj.bean
 * @ version : 1.0
 */
public class Role {
    private Integer id;
    private String name;
    private String nameZh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name==null?null:name.trim();
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }
}
