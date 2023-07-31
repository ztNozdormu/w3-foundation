package com.w3.module.infra.controller.admin.job;


import com.w3.framework.common.pojo.CommonResult;
import com.w3.framework.common.pojo.PageResult;
import com.w3.framework.excel.core.util.ExcelUtils;
import com.w3.framework.operatelog.core.annotations.OperateLog;
import com.w3.module.infra.api.dal.dataobject.job.JobLogDO;
import com.w3.module.infra.controller.admin.job.vo.log.JobLogExcelVO;
import com.w3.module.infra.controller.admin.job.vo.log.JobLogExportReqVO;
import com.w3.module.infra.controller.admin.job.vo.log.JobLogPageReqVO;
import com.w3.module.infra.controller.admin.job.vo.log.JobLogRespVO;
import com.w3.module.infra.convert.job.JobLogConvert;
import com.w3.module.infra.service.job.JobLogService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static com.w3.framework.common.pojo.CommonResult.success;
import static com.w3.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;


/**
 * 管理后台 - 定时任务日志
 */
@RestController
@RequestMapping("/infra/job-log")
@Validated
public class JobLogController {

    @Resource
    private JobLogService jobLogService;

    /**
     * 获得定时任务日志
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('infra:job:query')")
    public CommonResult<JobLogRespVO> getJobLog(@RequestParam("id") Long id) {
        JobLogDO jobLog = jobLogService.getJobLog(id);
        return success(JobLogConvert.INSTANCE.convert(jobLog));
    }

    /**
     * 获得定时任务日志列表
     * @param ids description = "编号列表", required = true, example = "1024,2048"
     * @return
     */
    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermission('infra:job:query')")
    public CommonResult<List<JobLogRespVO>> getJobLogList(@RequestParam("ids") Collection<Long> ids) {
        List<JobLogDO> list = jobLogService.getJobLogList(ids);
        return success(JobLogConvert.INSTANCE.convertList(list));
    }

    /**
     * 获得定时任务日志分页
     * @param pageVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('infra:job:query')")
    public CommonResult<PageResult<JobLogRespVO>> getJobLogPage(@Valid JobLogPageReqVO pageVO) {
        PageResult<JobLogDO> pageResult = jobLogService.getJobLogPage(pageVO);
        return success(JobLogConvert.INSTANCE.convertPage(pageResult));
    }

    /**
     * 导出定时任务日志 Excel
     * @param exportReqVO
     * @param response
     * @throws IOException
     */
    @GetMapping("/expoxrt-excel")
    @PreAuthorize("@ss.hasPermission('infra:job:export')")
    @OperateLog(type = EXPORT)
    public void exportJobLogExcel(@Valid JobLogExportReqVO exportReqVO,
                                  HttpServletResponse response) throws IOException {
        List<JobLogDO> list = jobLogService.getJobLogList(exportReqVO);
        // 导出 Excel
        List<JobLogExcelVO> datas = JobLogConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "任务日志.xls", "数据", JobLogExcelVO.class, datas);
    }

}
