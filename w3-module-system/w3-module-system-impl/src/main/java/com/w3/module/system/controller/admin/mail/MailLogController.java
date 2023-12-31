package com.w3.module.system.controller.admin.mail;


import com.w3.framework.common.pojo.CommonResult;
import com.w3.framework.common.pojo.PageResult;
import com.w3.module.system.controller.admin.mail.vo.log.MailLogPageReqVO;
import com.w3.module.system.controller.admin.mail.vo.log.MailLogRespVO;
import com.w3.module.system.convert.mail.MailLogConvert;
import com.w3.module.system.dal.dataobject.mail.MailLogDO;
import com.w3.module.system.service.mail.MailLogService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.w3.framework.common.pojo.CommonResult.success;


/**
 * 管理后台 - 邮件日志
 */
@RestController
@RequestMapping("/system/mail-log")
public class MailLogController {

    @Resource
    private MailLogService mailLogService;

    /**
     * 获得邮箱日志分页
     * @param pageVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:mail-log:query')")
    public CommonResult<PageResult<MailLogRespVO>> getMailLogPage(@Valid MailLogPageReqVO pageVO) {
        PageResult<MailLogDO> pageResult = mailLogService.getMailLogPage(pageVO);
        return success(MailLogConvert.INSTANCE.convertPage(pageResult));
    }

    /**
     * 获得邮箱日志
     * @param id  description = "编号", required = true, example = "1024"
     * @return
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:mail-log:query')")
    public CommonResult<MailLogRespVO> getMailTemplate(@RequestParam("id") Long id) {
        MailLogDO mailLogDO = mailLogService.getMailLog(id);
        return success(MailLogConvert.INSTANCE.convert(mailLogDO));
    }

}
