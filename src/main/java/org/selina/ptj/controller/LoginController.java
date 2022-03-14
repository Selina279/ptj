package org.selina.ptj.controller;

import org.selina.ptj.bean.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author : Selina
 * @ Date : 2020/4/20
 * @ Description : org.selina.ptj.controller
 * @ version : 1.0
 */
@RestController
public class LoginController {
    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("尚未登录，请先登录！");
    }
}
