package com.w3.module.system.controller.admin.sms;


import com.w3.framework.common.pojo.CommonResult;
import com.w3.framework.common.pojo.PageResult;
import com.w3.framework.excel.core.util.ExcelUtils;
import com.w3.framework.operatelog.core.annotations.OperateLog;
import com.w3.module.system.controller.admin.sms.vo.log.SmsLogExcelVO;
import com.w3.module.system.controller.admin.sms.vo.log.SmsLogExportReqVO;
import com.w3.module.system.controller.admin.sms.vo.log.SmsLogPageReqVO;
import com.w3.module.system.controller.admin.sms.vo.log.SmsLogRespVO;
import com.w3.module.system.convert.sms.SmsLogConvert;
import com.w3.module.system.dal.dataobject.sms.SmsLogDO;
import com.w3.module.system.service.sms.SmsLogService;
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

import static com.w3.framework.common.pojo.CommonResult.success;
import static com.w3.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;


/**
 * 管理后台 - 短信日志
 */
@RestController
@RequestMapping("/system/sms-log")
@Validated
public class SmsLogController {

    @Resource
    private SmsLogService smsLogService;

    /**
     * 获得短信日志分页
     * @param pageVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:sms-log:query')")
    public CommonResult<PageResult<SmsLogRespVO>> getSmsLogPage(@Valid SmsLogPageReqVO pageVO) {
        PageResult<SmsLogDO> pageResult = smsLogService.getSmsLogPage(pageVO);
        return success(SmsLogConvert.INSTANCE.convertPage(pageResult));
    }

    /**
     * 导出短信日志 Excel
     * @param exportReqVO
     * @param response
     * @throws IOException
     */
    @GetMapping("/export-excel")
    @PreAuthorize("@ss.hasPermission('system:sms-log:export')")
    @OperateLog(type = EXPORT)
    public void exportSmsLogExcel(@Valid SmsLogExportReqVO exportReqVO,
                                  HttpServletResponse response) throws IOException {
        List<SmsLogDO> list = smsLogService.getSmsLogList(exportReqVO);
        // 导出 Excel
        List<SmsLogExcelVO> datas = SmsLogConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "短信日志.xls", "数据", SmsLogExcelVO.class, datas);
    }

}
