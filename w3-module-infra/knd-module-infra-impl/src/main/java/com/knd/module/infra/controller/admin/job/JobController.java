package com.knd.module.infra.controller.admin.job;

import com.knd.framework.common.pojo.CommonResult;
import com.knd.framework.common.pojo.PageResult;
import com.knd.framework.excel.core.util.ExcelUtils;
import com.knd.framework.operatelog.core.annotations.OperateLog;
import com.knd.framework.quartz.core.util.CronUtils;
import com.knd.module.infra.api.dal.dataobject.job.JobDO;
import com.knd.module.infra.controller.admin.job.vo.job.*;
import com.knd.module.infra.convert.job.JobConvert;
import com.knd.module.infra.service.job.JobService;

import org.quartz.SchedulerException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.knd.framework.common.pojo.CommonResult.success;
import static com.knd.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;


/**
 * 管理后台 - 定时任务
 */
@RestController
@RequestMapping("/infra/job")
@Validated
public class JobController {

    @Resource
    private JobService jobService;

    /**
     * 创建定时任务
     * @param createReqVO
     * @return
     * @throws SchedulerException
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('infra:job:create')")
    public CommonResult<Long> createJob(@Valid @RequestBody JobCreateReqVO createReqVO)
            throws SchedulerException {
        return success(jobService.createJob(createReqVO));
    }

    /**
     * 更新定时任务
     * @param updateReqVO
     * @return
     * @throws SchedulerException
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('infra:job:update')")
    public CommonResult<Boolean> updateJob(@Valid @RequestBody JobUpdateReqVO updateReqVO)
            throws SchedulerException {
        jobService.updateJob(updateReqVO);
        return success(true);
    }

    /**
     * 更新定时任务的状态
     * @param id description = "编号", required = true, example = "1024"
     * @param status  description = "状态", required = true, example = "1"
     * @return
     * @throws SchedulerException
     */
    @PutMapping("/update-status")
    @PreAuthorize("@ss.hasPermission('infra:job:update')")
    public CommonResult<Boolean> updateJobStatus(@RequestParam(value = "id") Long id, @RequestParam("status") Integer status)
            throws SchedulerException {
        jobService.updateJobStatus(id, status);
        return success(true);
    }

    /**
     * 删除定时任务
     * @param id  description = "编号", required = true, example = "1024"
     * @return
     * @throws SchedulerException
     */
	@DeleteMapping("/delete")
	@PreAuthorize("@ss.hasPermission('infra:job:delete')")
    public CommonResult<Boolean> deleteJob(@RequestParam("id") Long id)
            throws SchedulerException {
        jobService.deleteJob(id);
        return success(true);
    }

    /**
     * 触发定时任务
     * @param id description = "编号", required = true, example = "1024"
     * @return
     * @throws SchedulerException
     */
    @PutMapping("/trigger")
    @PreAuthorize("@ss.hasPermission('infra:job:trigger')")
    public CommonResult<Boolean> triggerJob(@RequestParam("id") Long id) throws SchedulerException {
        jobService.triggerJob(id);
        return success(true);
    }

    /**
     * 获得定时任务
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('infra:job:query')")
    public CommonResult<JobRespVO> getJob(@RequestParam("id") Long id) {
        JobDO job = jobService.getJob(id);
        return success(JobConvert.INSTANCE.convert(job));
    }

    /**
     * 获得定时任务列表
     * @param ids description = "编号列表", required = true
     * @return
     */
    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermission('infra:job:query')")
    public CommonResult<List<JobRespVO>> getJobList(@RequestParam("ids") Collection<Long> ids) {
        List<JobDO> list = jobService.getJobList(ids);
        return success(JobConvert.INSTANCE.convertList(list));
    }

    /**
     * 获得定时任务分页
     * @param pageVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('infra:job:query')")
    public CommonResult<PageResult<JobRespVO>> getJobPage(@Valid JobPageReqVO pageVO) {
        PageResult<JobDO> pageResult = jobService.getJobPage(pageVO);
        return success(JobConvert.INSTANCE.convertPage(pageResult));
    }

    /**
     * 导出定时任务 Excel
     * @param exportReqVO
     * @param response
     * @throws IOException
     */
    @GetMapping("/export-excel")
    @PreAuthorize("@ss.hasPermission('infra:job:export')")
    @OperateLog(type = EXPORT)
    public void exportJobExcel(@Valid JobExportReqVO exportReqVO,
                               HttpServletResponse response) throws IOException {
        List<JobDO> list = jobService.getJobList(exportReqVO);
        // 导出 Excel
        List<JobExcelVO> datas = JobConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "定时任务.xls", "数据", JobExcelVO.class, datas);
    }

    /**
     * 获得定时任务的下 n 次执行时间
     * @param id  description = "编号", required = true, example = "1024"
     * @param count  description = "数量", example = "5"
     * @return
     */
    @GetMapping("/get_next_times")
    @PreAuthorize("@ss.hasPermission('infra:job:query')")
    public CommonResult<List<LocalDateTime>> getJobNextTimes(@RequestParam("id") Long id,
                                                   @RequestParam(value = "count", required = false, defaultValue = "5") Integer count) {
        JobDO job = jobService.getJob(id);
        if (job == null) {
            return success(Collections.emptyList());
        }
        return success(CronUtils.getNextTimes(job.getCronExpression(), count));
    }

}
