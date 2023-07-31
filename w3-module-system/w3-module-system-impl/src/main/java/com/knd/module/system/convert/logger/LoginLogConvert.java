package com.w3.module.system.convert.logger;


import com.w3.framework.common.pojo.PageResult;
import com.w3.module.system.api.logger.dto.LoginLogCreateReqDTO;
import com.w3.module.system.controller.admin.logger.vo.loginlog.LoginLogExcelVO;
import com.w3.module.system.controller.admin.logger.vo.loginlog.LoginLogRespVO;
import com.w3.module.system.dal.dataobject.logger.LoginLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LoginLogConvert {

    LoginLogConvert INSTANCE = Mappers.getMapper(LoginLogConvert.class);

    PageResult<LoginLogRespVO> convertPage(PageResult<LoginLogDO> page);

    List<LoginLogExcelVO> convertList(List<LoginLogDO> list);

    LoginLogDO convert(LoginLogCreateReqDTO bean);

}
