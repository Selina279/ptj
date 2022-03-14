package org.selina.ptj.bean;

/**
 * @ Author : Selina
 * @ Date : 2020/4/7
 * @ Description : org.selina.ptj.bean
 * @ version : 1.0
 */
public class Meta {

    private Boolean keepAlive;
    private Boolean requireAuth;

    public Boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
}
