package org.selina.ptj.service;

import org.selina.ptj.bean.JobState;
import org.selina.ptj.mapper.JobStateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author : Selina
 * @ Date : 2020/5/1
 * @ Description : org.selina.ptj.service
 * @ version : 1.0
 */

@Service
public class JobStateService {
    @Autowired
    JobStateMapper jobStateMapper;
    public List<JobState> getAllJobState(){
        return jobStateMapper.getAllJobState();
    }

}
