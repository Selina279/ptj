package org.selina.ptj.service;

import org.selina.ptj.bean.Menu;
import org.selina.ptj.bean.Role;
import org.selina.ptj.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author : Selina
 * @ Date : 2020/4/27
 * @ Description : org.selina.ptj.service
 * @ version : 1.0
 */
@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    public Integer addRole(Role role) {
        if(!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        return roleMapper.insert(role);
    }

    public Integer deleteRolesById(Integer uid) {
        return roleMapper.deleteRolesByPrimaryKey(uid);
    }
}
