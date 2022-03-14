package org.selina.ptj.controller.config;

import org.selina.ptj.bean.Menu;
import org.selina.ptj.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ Author : Selina
 * @ Date : 2020/4/22
 * @ Description : org.selina.ptj.controller
 * @ version : 1.0
 */
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {
    @Autowired
    MenuService menuService;
    @GetMapping("/menu")
    public List<Menu> getMenusByUserId(){
        return menuService.getMenusByUserId();
    }
}
