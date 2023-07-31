package com.knd.module.infra.controller.admin.logger;


import com.knd.framework.common.pojo.CommonResult;
import com.knd.framework.common.pojo.PageResult;
import com.knd.framework.excel.core.util.ExcelUtils;
import com.knd.framework.operatelog.core.annotations.OperateLog;
import com.knd.module.infra.api.dal.dataobject.logger.ApiErrorLogDO;
import com.knd.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogExcelVO;
import com.knd.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogExportReqVO;
import com.knd.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogPageReqVO;
import com.knd.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogRespVO;
import com.knd.module.infra.convert.logger.ApiErrorLogConvert;
import com.knd.module.infra.service.logger.ApiErrorLogService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static com.knd.framework.common.pojo.CommonResult.success;
import static com.knd.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;
import static com.knd.framework.web.core.util.WebFrameworkUtils.getLoginUserId;


/**
 * 管理后台 - API 错误日志
 */
@RestController
@RequestMapping("/infra/api-error-log")
@Validated
public class ApiErrorLogController {

    @Resource
    private ApiErrorLogService apiErrorLogService;

    /**
     * 更新 API 错误日志的状态
     * @param id description = "编号", required = true, example = "1024"
     * @param processStatus  description = "处理状态", required = true, example = "1"
     * @return
     */
    @PutMapping("/update-status")
    @PreAuthorize("@ss.hasPermission('infra:api-error-log:update-status')")
    public CommonResult<Boolean> updateApiErrorLogProcess(@RequestParam("id") Long id,
                                                          @RequestParam("processStatus") Integer processStatus) {
        apiErrorLogService.updateApiErrorLogProcess(id, processStatus, getLoginUserId());
        return success(true);
    }

    /**
     * 获得 API 错误日志分页
     * @param pageVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('infra:api-error-log:query')")
    public CommonResult<PageResult<ApiErrorLogRespVO>> getApiErrorLogPage(@Valid ApiErrorLogPageReqVO pageVO) {
        PageResult<ApiErrorLogDO> pageResult = apiErrorLogService.getApiErrorLogPage(pageVO);
        return success(ApiErrorLogConvert.INSTANCE.convertPage(pageResult));
    }

    /**
     * 导出 API 错误日志 Excel
     * @param exportReqVO
     * @param response
     * @throws IOException
     */
    @GetMapping("/export-excel")
    @PreAuthorize("@ss.hasPermission('infra:api-error-log:export')")
    @OperateLog(type = EXPORT)
    public void exportApiErrorLogExcel(@Valid ApiErrorLogExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ApiErrorLogDO> list = apiErrorLogService.getApiErrorLogList(exportReqVO);
        // 导出 Excel
        List<ApiErrorLogExcelVO> datas = ApiErrorLogConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "API 错误日志.xls", "数据", ApiErrorLogExcelVO.class, datas);
    }

}
