package org.selina.ptj.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @ Author : Selina
 * @ Date : 2020/4/28
 * @ Description : org.selina.ptj.mapper
 * @ version : 1.0
 */
public interface MenuRoleMapper {

    void deleteById(Integer uid);

    Integer insertRecord(@Param("uid") Integer uid,@Param("mids") Integer[] mids);
}
