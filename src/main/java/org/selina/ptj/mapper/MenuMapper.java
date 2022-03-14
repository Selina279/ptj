package org.selina.ptj.mapper;

import org.selina.ptj.bean.Menu;

import java.util.List;

/**
 * @ Author : Selina
 * @ Date : 2020/4/22
 * @ Description : org.selina.ptj.mapper
 * @ version : 1.0
 */
public interface MenuMapper {

    List<Menu> getMenusByUserId(Integer userid);

    List<Menu> getAllMenusWithRole();

    List<Menu> getAllMenus();

    List<Integer> getMidsByUid(Integer uid);
}
