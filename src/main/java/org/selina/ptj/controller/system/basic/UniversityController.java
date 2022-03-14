package org.selina.ptj.controller.system.basic;

import org.selina.ptj.bean.RespBean;
import org.selina.ptj.bean.University;
import org.selina.ptj.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Author : Selina
 * @ Date : 2020/4/25
 * @ Description : org.selina.ptj.controller.system.basic
 * @ version : 1.0
 */
@RestController
@RequestMapping("/system/basic/uni")
public class UniversityController {
    @Autowired
    UniversityService universityService;
    @GetMapping("/")
    public List<University> getAllUniversities(){
        return universityService.getAllUniversities( );
    }
    @PostMapping("/")
    public RespBean addUniversity(@RequestBody University university){
        if(universityService.addUniversity(university)==1){
            return RespBean.ok("添加成功!");
        }else{
            return RespBean.error("添加失败!");
        }
    }
    @PutMapping("/")
    public RespBean updateUniversity(@RequestBody University university){
        if(universityService.updateUniversity(university)==1){
            return RespBean.ok("更新成功!");
        }else{
            return RespBean.error("更新失败!");
        }
    }
    @DeleteMapping("/{id}")
    public RespBean deleteUniversityById(@PathVariable Integer id){
        if(universityService.deleteUniversityById(id)==1){
            return RespBean.ok("删除成功!");
        }else{
            return RespBean.error("删除失败!");
        }
    }
    @DeleteMapping("/}")
    public RespBean deletePositionsByIds(Integer[] ids) {
        if (universityService.deletePositionsByIds(ids) == ids.length) {
            return RespBean.ok("批量删除成功!");
        }
        return RespBean.error("批量删除失败!");
    }

}
