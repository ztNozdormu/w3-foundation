package com.knd.module.system.single.controller.admin.logger;


import com.knd.framework.common.pojo.CommonResult;
import com.knd.framework.common.pojo.PageResult;
import com.knd.framework.excel.core.util.ExcelUtils;
import com.knd.framework.operatelog.core.annotations.OperateLog;
import com.knd.module.system.convert.logger.LoginLogConvert;
import com.knd.module.system.dal.dataobject.logger.LoginLogDO;
import com.knd.module.system.service.logger.LoginLogService;
import com.knd.module.system.single.controller.admin.logger.vo.loginlog.LoginLogExcelVO;
import com.knd.module.system.single.controller.admin.logger.vo.loginlog.LoginLogExportReqVO;
import com.knd.module.system.single.controller.admin.logger.vo.loginlog.LoginLogPageReqVO;
import com.knd.module.system.single.controller.admin.logger.vo.loginlog.LoginLogRespVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static com.knd.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;


/**
 * 管理后台 - 登录日志
 */
@RestController
@RequestMapping("/system/login-log")
@Validated
public class LoginLogController {

    @Resource
    private LoginLogService loginLogService;

    /**
     * 获得登录日志分页列表
     * @param reqVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:login-log:query')")
    public CommonResult<PageResult<LoginLogRespVO>> getLoginLogPage(@Valid LoginLogPageReqVO reqVO) {
        PageResult<LoginLogDO> page = loginLogService.getLoginLogPage(reqVO);
        return CommonResult.success(LoginLogConvert.INSTANCE.convertPage(page));
    }

    /**
     * 导出登录日志 Excel
     * @param response
     * @param reqVO
     * @throws IOException
     */
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPermission('system:login-log:export')")
    @OperateLog(type = EXPORT)
    public void exportLoginLog(HttpServletResponse response, @Valid LoginLogExportReqVO reqVO) throws IOException {
        List<LoginLogDO> list = loginLogService.getLoginLogList(reqVO);
        // 拼接数据
        List<LoginLogExcelVO> data = LoginLogConvert.INSTANCE.convertList(list);
        // 输出
        ExcelUtils.write(response, "登录日志.xls", "数据列表", LoginLogExcelVO.class, data);
    }

}
