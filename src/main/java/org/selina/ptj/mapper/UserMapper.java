package org.selina.ptj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.selina.ptj.bean.Role;
import org.selina.ptj.bean.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ Author : Selina
 * @ Date : 2020/4/20
 * @ Description : org.selina.ptj.mapper
 * @ version : 1.0
 */
@Mapper
@Component
public interface UserMapper {

    User loadUserByUsername(String username);

    List<Role> getUserRolesById(Integer id);

    List<User> getAllUsers(@Param("userid") Integer userid,@Param("keywords") String keywords);

    int updateByPrimaryKeySelective(User record);

    int deleteByPrimaryKey(Integer id);
}
