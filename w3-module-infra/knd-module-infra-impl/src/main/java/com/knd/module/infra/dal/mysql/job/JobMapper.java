package com.knd.module.infra.dal.mysql.job;

import com.knd.framework.common.pojo.PageResult;
import com.knd.framework.mybatis.core.mapper.BaseMapperX;
import com.knd.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.knd.module.infra.api.dal.dataobject.job.JobDO;
import com.knd.module.infra.controller.admin.job.vo.job.JobExportReqVO;
import com.knd.module.infra.controller.admin.job.vo.job.JobPageReqVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 定时任务 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface JobMapper extends BaseMapperX<JobDO> {

    default JobDO selectByHandlerName(String handlerName) {
        return selectOne(JobDO::getHandlerName, handlerName);
    }

    default PageResult<JobDO> selectPage(JobPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JobDO>()
                .likeIfPresent(JobDO::getName, reqVO.getName())
                .eqIfPresent(JobDO::getStatus, reqVO.getStatus())
                .likeIfPresent(JobDO::getHandlerName, reqVO.getHandlerName())
        );
    }

    default List<JobDO> selectList(JobExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<JobDO>()
                .likeIfPresent(JobDO::getName, reqVO.getName())
                .eqIfPresent(JobDO::getStatus, reqVO.getStatus())
                .likeIfPresent(JobDO::getHandlerName, reqVO.getHandlerName())
        );
    }

}
