package com.knd.module.infra.dal.mysql.logger;


import com.knd.framework.common.pojo.PageResult;
import com.knd.framework.mybatis.core.mapper.BaseMapperX;
import com.knd.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.knd.module.infra.api.dal.dataobject.logger.ApiErrorLogDO;
import com.knd.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogExportReqVO;
import com.knd.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogPageReqVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * API 错误日志 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ApiErrorLogMapper extends BaseMapperX<ApiErrorLogDO> {

    default PageResult<ApiErrorLogDO> selectPage(ApiErrorLogPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ApiErrorLogDO>()
                .eqIfPresent(ApiErrorLogDO::getUserId, reqVO.getUserId())
                .eqIfPresent(ApiErrorLogDO::getUserType, reqVO.getUserType())
                .eqIfPresent(ApiErrorLogDO::getApplicationName, reqVO.getApplicationName())
                .likeIfPresent(ApiErrorLogDO::getRequestUrl, reqVO.getRequestUrl())
                .betweenIfPresent(ApiErrorLogDO::getExceptionTime, reqVO.getExceptionTime())
                .eqIfPresent(ApiErrorLogDO::getProcessStatus, reqVO.getProcessStatus())
                .orderByDesc(ApiErrorLogDO::getId));
    }

    default List<ApiErrorLogDO> selectList(ApiErrorLogExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ApiErrorLogDO>()
                .eqIfPresent(ApiErrorLogDO::getUserId, reqVO.getUserId())
                .eqIfPresent(ApiErrorLogDO::getUserType, reqVO.getUserType())
                .eqIfPresent(ApiErrorLogDO::getApplicationName, reqVO.getApplicationName())
                .likeIfPresent(ApiErrorLogDO::getRequestUrl, reqVO.getRequestUrl())
                .betweenIfPresent(ApiErrorLogDO::getExceptionTime, reqVO.getExceptionTime())
                .eqIfPresent(ApiErrorLogDO::getProcessStatus, reqVO.getProcessStatus())
                .orderByDesc(ApiErrorLogDO::getId)
        );
    }

}
