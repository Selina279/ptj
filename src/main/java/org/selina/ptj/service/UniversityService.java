package org.selina.ptj.service;

import org.selina.ptj.bean.University;
import org.selina.ptj.mapper.UniversityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ Author : Selina
 * @ Date : 2020/4/25
 * @ Description : org.selina.ptj.service
 * @ version : 1.0
 */
@Service
public class UniversityService {
    @Autowired
    UniversityMapper universityMapper;
    public List<University> getAllUniversities() {
        return universityMapper.getAllUniversities();
    }

    public Integer addUniversity(University university) {
        university.setEnabled(true);
        university.setCreateDate(new Date());
        return universityMapper.insertSelective(university);
    }

    public Integer updateUniversity(University university) {
        return universityMapper.updateByPrimaryKeySelective(university);
    }

    public Integer deleteUniversityById(Integer id){
        return universityMapper.deleteByPrimaryKey(id);
    }

    public Integer deletePositionsByIds(Integer[] ids) {
        return universityMapper.deleteUniversityByIds(ids);
    }
}
