package org.selina.ptj.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @ Author : Selina
 * @ Date : 2020/5/1
 * @ Description : org.selina.ptj.mapper
 * @ version : 1.0
 */
public interface UserRoleMapper {

    void deleteByUserId(Integer userid);

    Integer addRole(@Param("userid") Integer userid,@Param("uids") Integer[] uids);
}
