package com.w3.module.infra.convert.logger;


import com.w3.framework.common.pojo.PageResult;
import com.w3.module.infra.api.dal.dataobject.logger.ApiErrorLogDO;
import com.w3.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import com.w3.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogExcelVO;
import com.w3.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogRespVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * API 错误日志 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ApiErrorLogConvert {

    ApiErrorLogConvert INSTANCE = Mappers.getMapper(ApiErrorLogConvert.class);

    ApiErrorLogRespVO convert(ApiErrorLogDO bean);

    PageResult<ApiErrorLogRespVO> convertPage(PageResult<ApiErrorLogDO> page);

    List<ApiErrorLogExcelVO> convertList02(List<ApiErrorLogDO> list);

    ApiErrorLogDO convert(ApiErrorLogCreateReqDTO bean);

}
