package org.selina.ptj.mapper;

import org.apache.ibatis.annotations.Param;
import org.selina.ptj.bean.Business;

import java.util.List;

/**
 * @ Author : Selina
 * @ Date : 2020/4/26
 * @ Description : org.selina.ptj.mapper
 * @ version : 1.0
 */
public interface BusinessMapper {
    List<Business> getAllBusiness();

    int insertSelective(Business record);

    int updateByPrimaryKeySelective(Business record);

    int deleteByPrimaryKey(Integer id);

    Integer deleteBusinessByIds(@Param("ids") Integer[] ids);
}
