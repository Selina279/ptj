package org.selina.ptj.mapper;

import org.apache.ibatis.annotations.Param;
import org.selina.ptj.bean.Job;
import java.util.List;

/**
 * @ Author : Selina
 * @ Date : 2020/4/11
 * @ Description : org.selina.ptj.mapper
 * @ version : 1.0
 */

public interface JobMapper {
    List<Job> getJobByPage(@Param("page") Integer page, @Param("size") Integer size,@Param("keyword") String keyword);

    Long getTotal(String keyword);

    Integer insertSelective(Job job);

    Integer deleteByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(Job job);

    Integer addJobs(@Param("list") List<Job> list);

    Integer passJob(Integer id);
}
