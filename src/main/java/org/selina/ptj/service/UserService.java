package org.selina.ptj.service;

import org.selina.ptj.mapper.RoleMapper;
import org.selina.ptj.mapper.UserMapper;
import org.selina.ptj.mapper.UserRoleMapper;
import org.selina.ptj.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.selina.ptj.bean.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ Author : Selina
 * @ Date : 2020/4/20
 * @ Description : org.selina.ptj.service
 * @ version : 1.0
 */
@Service
public class UserService implements UserDetailsService {
   @Autowired
   UserMapper userMapper;
   @Autowired
   UserRoleMapper userRoleMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userMapper.loadUserByUsername(username);
        if(user==null)
        {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        user.setRoles(userMapper.getUserRolesById(user.getId()));
        return user;
    }

    public List<User> getAllUsers(String keywords) {
        return userMapper.getAllUsers(UserUtils.getCurrentUser().getId(),keywords);
    }

    public Integer updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Transactional
    //一个删除一个添加，为了确保同时成功
    public boolean updateUserRole(Integer userid, Integer[] uids) {
        userRoleMapper.deleteByUserId(userid);
        return userRoleMapper.addRole(userid,uids)==uids.length;
    }

    public Integer deleteUserById(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }
}
