package org.selina.ptj.mapper;

import org.selina.ptj.bean.Role;

import java.util.List;

/**
 * @ Author : Selina
 * @ Date : 2020/4/27
 * @ Description : org.selina.ptj.mapper
 * @ version : 1.0
 */
public interface RoleMapper {
    List<Role> getAllRoles();

    int insert(Role record);

    int deleteRolesByPrimaryKey(Integer id);
}
