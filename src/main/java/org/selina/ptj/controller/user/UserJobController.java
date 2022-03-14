package org.selina.ptj.controller.user;

import org.selina.ptj.bean.Business;
import org.selina.ptj.bean.Job;
import org.selina.ptj.bean.RespBean;
import org.selina.ptj.bean.RespPageBean;
import org.selina.ptj.service.BusinessService;
import org.selina.ptj.service.JobService;
import org.selina.ptj.service.JobStateService;
import org.selina.ptj.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ Author : Selina
 * @ Date : 2020/4/10
 * @ Description : org.selina.ptj.controller.user
 * @ version : 1.0
 */

@RestController
@RequestMapping("/user/job")
public class UserJobController {

    @Autowired
    JobService jobService;

    @Autowired
    JobStateService jobStateService;

    @Autowired
    BusinessService businessService;

    //默认查询第1页，每页查询10条
    @GetMapping("/")
    public RespPageBean getJobByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, String keyword ){
//        System.out.println(job);
//        System.out.println(Arrays.toString(beginDateScope));
        return jobService.getJobByPage(page,size,keyword);
    }

    @PostMapping("/")
    public RespBean addJob(@RequestBody Job job){
        if(jobService.addJob(job)==1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @GetMapping("/business")
    public List<Business> getAllBusiness(){
        return businessService.getAllBusiness();
    }

    @DeleteMapping("/{id}")
    public RespBean passJobByJid(@PathVariable Integer id){
        if(jobService.passJobByJid(id)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateJob(@RequestBody Job job){
        if(jobService.updateJob(job)==1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @PutMapping("/pass/{id}")
    public RespBean passJob(@PathVariable Integer id){
        if(jobService.passJob(id)==1){
            return RespBean.ok("审核通过！");
        }
        return RespBean.error("审核失败！");
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData() throws IOException {
        List<Job> list = (List<Job>) jobService.getJobByPage(null, null, null).getData();
        return POIUtils.employee2Excel(list);
    }

    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException {
        List<Job> list=POIUtils.excel2Job(file);

//        if(jobService.addJobs(list)==list.size()){
//            return RespBean.ok("上传成功！");
//        }
        for(Job job:list){
            System.out.println(job);
        }
        return RespBean.error("上传成功！");
    }

}
