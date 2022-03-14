package org.selina.ptj.controller.system.basic;

import org.apache.ibatis.annotations.Delete;
import org.selina.ptj.bean.Business;
import org.selina.ptj.bean.RespBean;
import org.selina.ptj.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ResourceBundle;

/**
 * @ Author : Selina
 * @ Date : 2020/4/26
 * @ Description : org.selina.ptj.controller.system.basic
 * @ version : 1.0
 */
@RestControllerAdvice
@RequestMapping("/system/basic/bus")
public class BusinessController {

    @Autowired
    BusinessService businessService;

    @GetMapping("/")
    public List<Business> getAllBusiness(){
        return businessService.getAllBusiness();
    }

    @PostMapping("/")
    public RespBean addBusiness(@RequestBody Business business) {
        if(businessService.addBusiness(business)==1){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/")
    public RespBean updateBusiness(@RequestBody Business business){
        if(businessService.updateBusinessById(business)==1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }


    @DeleteMapping("/{id}")
    public RespBean deleteBusinessById(@PathVariable Integer id){
        if(businessService.deleteBusinessById(id)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @DeleteMapping("/")
    public RespBean deleteBusinessByIds(Integer[] ids){
        if(businessService.deleteBusinessByIds(ids)==ids.length){
            return RespBean.ok("批量删除成功！");
        }
        return RespBean.error("批量删除失败！");
    }
}
