package org.selina.ptj.service;

import org.selina.ptj.bean.Menu;
import org.selina.ptj.bean.User;
import org.selina.ptj.mapper.MenuMapper;
import org.selina.ptj.mapper.MenuRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ Author : Selina
 * @ Date : 2020/4/22
 * @ Description : org.selina.ptj.service
 * @ version : 1.0
 */
@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    MenuRoleMapper menuRoleMapper;

    public List<Menu> getMenusByUserId() {
        return menuMapper.getMenusByUserId(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }
//    @Cacheable
    public List<Menu> getAllMenusWithRole(){
        return menuMapper.getAllMenusWithRole();
    }

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();


    }

    public List<Integer> getMidsByUid(Integer uid) {
        return menuMapper.getMidsByUid(uid);
    }

    @Transactional
    public boolean updateMenuRole(Integer uid, Integer[] mids) {
        menuRoleMapper.deleteById(uid);
        if(mids==null || mids.length==0){
            return true;
        }
        Integer result=menuRoleMapper.insertRecord(uid,mids);
        return result== mids.length;
    }
}
