package org.selina.ptj.controller.system.basic;

import org.selina.ptj.bean.Menu;
import org.selina.ptj.bean.RespBean;
import org.selina.ptj.bean.Role;
import org.selina.ptj.service.MenuService;
import org.selina.ptj.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Author : Selina
 * @ Date : 2020/4/27
 * @ Description : org.selina.ptj.controller.system.basic
 * @ version : 1.0
 */
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {

    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;

    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }

    @GetMapping("/mids/{uid}")
    public List<Integer> getMidsByUid(@PathVariable Integer uid){
        return menuService.getMidsByUid(uid);
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer uid,Integer[] mids){
        if(menuService.updateMenuRole(uid,mids)){
            return RespBean.ok("更新成功！");
        }
            return RespBean.error("更新失败！");
    }

    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role){
        if(roleService.addRole(role)==1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @DeleteMapping("/role/{uid}")
    public RespBean deleteRoleById( @PathVariable Integer uid){
        if(roleService.deleteRolesById(uid)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}
