package org.selina.ptj.service;

import org.selina.ptj.bean.Business;
import org.selina.ptj.mapper.BusinessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ Author : Selina
 * @ Date : 2020/4/26
 * @ Description : org.selina.ptj.service
 * @ version : 1.0
 */
@Service
public class BusinessService {
    @Autowired
    BusinessMapper businessMapper;
    public List<Business> getAllBusiness() {
        return businessMapper.getAllBusiness();
    }


    public Integer addBusiness(Business business) {
        business.setCreateDate(new Date());
        business.setEnabled(true);
        return businessMapper.insertSelective(business);
    }

    public Integer updateBusinessById(Business business) {
        return businessMapper.updateByPrimaryKeySelective(business);
    }

    public Integer deleteBusinessById(Integer id) {
        return businessMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteBusinessByIds(Integer[] ids) {

        return businessMapper.deleteBusinessByIds(ids);
    }
}
