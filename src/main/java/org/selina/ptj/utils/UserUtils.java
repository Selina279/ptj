package org.selina.ptj.utils;

import org.selina.ptj.bean.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @ Author : Selina
 * @ Date : 2020/5/1
 * @ Description : org.selina.ptj.utils
 * @ version : 1.0
 * 获取当前用户信息
 */
public class UserUtils {
    public static User getCurrentUser(){
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
