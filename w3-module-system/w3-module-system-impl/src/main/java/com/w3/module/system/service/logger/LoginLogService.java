package com.w3.module.system.service.logger;

import com.w3.framework.common.pojo.PageResult;
import com.w3.module.system.api.logger.dto.LoginLogCreateReqDTO;
import com.w3.module.system.controller.admin.logger.vo.loginlog.LoginLogExportReqVO;
import com.w3.module.system.controller.admin.logger.vo.loginlog.LoginLogPageReqVO;
import com.w3.module.system.dal.dataobject.logger.LoginLogDO;

import javax.validation.Valid;
import java.util.List;

/**
 * 登录日志 Service 接口
 */
public interface LoginLogService {

    /**
     * 获得登录日志分页
     *
     * @param reqVO 分页条件
     * @return 登录日志分页
     */
    PageResult<LoginLogDO> getLoginLogPage(LoginLogPageReqVO reqVO);

    /**
     * 获得登录日志列表
     *
     * @param reqVO 列表条件
     * @return 登录日志列表
     */
    List<LoginLogDO> getLoginLogList(LoginLogExportReqVO reqVO);

    /**
     * 创建登录日志
     *
     * @param reqDTO 日志信息
     */
    void createLoginLog(@Valid LoginLogCreateReqDTO reqDTO);

}
