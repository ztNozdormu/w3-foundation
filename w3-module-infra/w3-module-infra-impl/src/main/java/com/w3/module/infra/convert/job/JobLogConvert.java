package com.w3.module.infra.convert.job;


import com.w3.framework.common.pojo.PageResult;
import com.w3.module.infra.api.dal.dataobject.job.JobLogDO;
import com.w3.module.infra.controller.admin.job.vo.log.JobLogExcelVO;
import com.w3.module.infra.controller.admin.job.vo.log.JobLogRespVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 定时任务日志 Convert
 *
 */
@Mapper
public interface JobLogConvert {

    JobLogConvert INSTANCE = Mappers.getMapper(JobLogConvert.class);

    JobLogRespVO convert(JobLogDO bean);

    List<JobLogRespVO> convertList(List<JobLogDO> list);

    PageResult<JobLogRespVO> convertPage(PageResult<JobLogDO> page);

    List<JobLogExcelVO> convertList02(List<JobLogDO> list);

}
