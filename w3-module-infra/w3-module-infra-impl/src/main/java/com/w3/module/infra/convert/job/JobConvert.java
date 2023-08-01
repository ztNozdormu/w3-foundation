package com.w3.module.infra.convert.job;


import com.w3.framework.common.pojo.PageResult;
import com.w3.module.infra.api.dal.dataobject.job.JobDO;
import com.w3.module.infra.controller.admin.job.vo.job.JobCreateReqVO;
import com.w3.module.infra.controller.admin.job.vo.job.JobExcelVO;
import com.w3.module.infra.controller.admin.job.vo.job.JobRespVO;
import com.w3.module.infra.controller.admin.job.vo.job.JobUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 定时任务 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface JobConvert {

    JobConvert INSTANCE = Mappers.getMapper(JobConvert.class);

    JobDO convert(JobCreateReqVO bean);

    JobDO convert(JobUpdateReqVO bean);

    JobRespVO convert(JobDO bean);

    List<JobRespVO> convertList(List<JobDO> list);

    PageResult<JobRespVO> convertPage(PageResult<JobDO> page);

    List<JobExcelVO> convertList02(List<JobDO> list);

}
