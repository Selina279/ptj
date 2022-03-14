package org.selina.ptj.mapper;

import org.apache.ibatis.annotations.Param;
import org.selina.ptj.bean.University;

import java.util.List;

/**
 * @ Author : Selina
 * @ Date : 2020/4/25
 * @ Description : org.selina.ptj.mapper
 * @ version : 1.0
 */
public interface UniversityMapper {
    List<University> getAllUniversities();

    int insertSelective(University record);

    int updateByPrimaryKeySelective(University record);

    int deleteByPrimaryKey(Integer id);

    Integer deleteUniversityByIds(@Param("ids") Integer[] ids);
}
