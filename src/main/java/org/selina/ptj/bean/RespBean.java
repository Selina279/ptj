package org.selina.ptj.bean;

/**
 * @ Author : Selina
 * @ Date : 2020/4/7
 * @ Description : org.selina.ptj.bean
 * @ version : 1.0
 */
public class RespBean {
    private Integer statue;
    private String msg;
    private Object obj;

    public static RespBean ok(String msg) {
        return new RespBean(200,msg,null);
    }
    public static RespBean ok(String msg,Object obj) {
        return new RespBean(200,msg,obj);
    }

    public static RespBean error(String msg) {
        return new RespBean(500,msg,null);
    }
    public static RespBean error(String msg,Object obj) {
        return new RespBean(500,msg,obj);
    }

    private RespBean() {
    }

    private RespBean(Integer statue, String msg, Object obj) {
        this.statue = statue;
        this.msg = msg;
        this.obj = obj;
    }

    public Integer getStatue() {
        return statue;
    }

    public void setStatue(Integer statue) {
        this.statue = statue;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
