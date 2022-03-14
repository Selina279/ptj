package org.selina.ptj.bean;

import java.util.Objects;

/**
 * @ Author : Selina
 * @ Date : 2020/4/28
 * @ Description : org.selina.ptj.bean
 * @ version : 1.0
 */
public class JobState {
    private Integer id;
    private String stateZh;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobState jobState = (JobState) o;
        return Objects.equals(stateZh, jobState.stateZh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stateZh);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStateZh() {
        return stateZh;
    }

    public void setStateZh(String stateZh) {
        this.stateZh = stateZh;
    }
}
