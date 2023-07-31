package com.knd.module.infra.single.convert.job;


import com.knd.framework.common.pojo.PageResult;
import com.knd.module.infra.api.dal.dataobject.job.JobDO;
import com.knd.module.infra.single.controller.admin.job.vo.job.JobCreateReqVO;
import com.knd.module.infra.single.controller.admin.job.vo.job.JobExcelVO;
import com.knd.module.infra.single.controller.admin.job.vo.job.JobRespVO;
import com.knd.module.infra.single.controller.admin.job.vo.job.JobUpdateReqVO;
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
