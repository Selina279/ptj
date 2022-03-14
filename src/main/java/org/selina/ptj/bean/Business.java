package org.selina.ptj.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ Author : Selina
 * @ Date : 2020/4/7
 * @ Description : org.selina.ptj.bean
 * @ version : 1.0
 */
public class Business {
    private Integer id;
    private String name;
    private String type;

    @JsonFormat(pattern = "yyy-MM-dd",timezone ="Asia/Shanghai")
    private Date createDate;
    private Boolean enabled;
    private String local;

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", createDate=" + createDate +
                ", enabled=" + enabled +
                ", local='" + local + '\'' +
                '}';
    }

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
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
