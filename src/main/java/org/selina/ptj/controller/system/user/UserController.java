package org.selina.ptj.controller.system.user;

import org.selina.ptj.bean.RespBean;
import org.selina.ptj.bean.Role;
import org.selina.ptj.bean.User;
import org.selina.ptj.service.RoleService;
import org.selina.ptj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Author : Selina
 * @ Date : 2020/4/10
 * @ Description : org.selina.ptj.controller.system.user
 * @ version : 1.0
 */

@RestController
@RequestMapping("/system/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @GetMapping("/")
    public List<User> getAllUsers(String keywords){
        return userService.getAllUsers(keywords);
    }

    @PutMapping("/")
    public RespBean updateUser(@RequestBody User user){
        if(userService.updateUser(user)==1){
             return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateUserRole(Integer userid,Integer[] uids){
        if(userService.updateUserRole(userid,uids)){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteUserById(@PathVariable Integer id){
        if(userService.deleteUserById(id)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}
