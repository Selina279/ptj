package org.selina.ptj.controller;

import org.selina.ptj.bean.RespBean;
import org.selina.ptj.bean.User;
import org.selina.ptj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @ Author : Selina
 * @ Date : 2020/5/1
 * @ Description : org.selina.ptj.controller
 * @ version : 1.0
 */
@RestController
public class UserInfoController {

    @Autowired
    UserService userService;
//
//    @Value("${fastdds.nginx.host}")
//    String nginxHost;

    @GetMapping("/user/info")
    public User getCurrentUser(Authentication authentication){
        return ((User) authentication.getPrincipal());
    }
    @PutMapping("/user/info")
    public RespBean updateUser(@RequestBody User user,Authentication authentication){
        if(userService.updateUser(user)==1){
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user,authentication.getCredentials(),authentication.getAuthorities()));
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }
}
