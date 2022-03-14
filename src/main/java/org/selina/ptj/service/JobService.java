package org.selina.ptj.service;

import org.selina.ptj.bean.Job;
import org.selina.ptj.bean.RespPageBean;
import org.selina.ptj.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ Author : Selina
 * @ Date : 2020/4/10
 * @ Description : org.selina.ptj.service
 * @ version : 1.0
 */
@Service
public class JobService {

    @Autowired
    JobMapper jobMapper;

    public RespPageBean getJobByPage(Integer page, Integer size, String keyword) {
        if(page!=null && size!=null){
            page=(page-1)*size;
        }
        List<Job> data=jobMapper.getJobByPage(page,size,keyword);
        Long total=jobMapper.getTotal(keyword);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addJob(Job job) {
        return jobMapper.insertSelective(job);
    }

    public Integer passJobByJid(Integer id) {
        return jobMapper.deleteByPrimaryKey(id);
    }

    public Integer updateJob(Job job) {
        return jobMapper.updateByPrimaryKeySelective(job);
    }

    public Integer addJobs(List<Job> list) {
        return jobMapper.addJobs(list);
    }

    public Integer passJob(Integer id) {
        return jobMapper.passJob(id);
    }
}
