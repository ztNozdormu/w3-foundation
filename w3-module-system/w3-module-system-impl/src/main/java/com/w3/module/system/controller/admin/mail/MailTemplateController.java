package com.w3.module.system.controller.admin.mail;


import com.w3.framework.common.pojo.CommonResult;
import com.w3.framework.common.pojo.PageResult;
import com.w3.module.system.controller.admin.mail.vo.template.*;
import com.w3.module.system.convert.mail.MailTemplateConvert;
import com.w3.module.system.dal.dataobject.mail.MailTemplateDO;
import com.w3.module.system.service.mail.MailSendService;
import com.w3.module.system.service.mail.MailTemplateService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static com.w3.framework.common.pojo.CommonResult.success;


/**
 * 管理后台 - 邮件模版
 */
@RestController
@RequestMapping("/system/mail-template")
public class MailTemplateController {

    @Resource
    private MailTemplateService mailTempleService;
    @Resource
    private MailSendService mailSendService;

    /**
     * 创建邮件模版
     * @param createReqVO
     * @return
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:mail-template:create')")
    public CommonResult<Long> createMailTemplate(@Valid @RequestBody MailTemplateCreateReqVO createReqVO){
        return success(mailTempleService.createMailTemplate(createReqVO));
    }

    /**
     * 修改邮件模版
     * @param updateReqVO
     * @return
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:mail-template:update')")
    public CommonResult<Boolean> updateMailTemplate(@Valid @RequestBody MailTemplateUpdateReqVO updateReqVO){
        mailTempleService.updateMailTemplate(updateReqVO);
        return success(true);
    }

    /**
     * 删除邮件模版
     * @param id  description = "编号", required = true, example = "1024"
     * @return
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:mail-template:delete')")
    public CommonResult<Boolean> deleteMailTemplate(@RequestParam("id") Long id) {
        mailTempleService.deleteMailTemplate(id);
        return success(true);
    }

    /**
     * 获得邮件模版
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:mail-template:get')")
    public CommonResult<MailTemplateRespVO> getMailTemplate(@RequestParam("id") Long id) {
        MailTemplateDO mailTemplateDO = mailTempleService.getMailTemplate(id);
        return success(MailTemplateConvert.INSTANCE.convert(mailTemplateDO));
    }

    /**
     * 获得邮件模版分页
     * @param pageReqVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:mail-template:query')")
    public CommonResult<PageResult<MailTemplateRespVO>> getMailTemplatePage(@Valid MailTemplatePageReqVO pageReqVO) {
        PageResult<MailTemplateDO> pageResult = mailTempleService.getMailTemplatePage(pageReqVO);
        return success(MailTemplateConvert.INSTANCE.convertPage(pageResult));
    }

    /**
     * 获得邮件模版精简列表
     * @return
     */
    @GetMapping("/list-all-simple")
    public CommonResult<List<MailTemplateSimpleRespVO>> getSimpleTemplateList() {
        List<MailTemplateDO> list = mailTempleService.getMailTemplateList();
        return success(MailTemplateConvert.INSTANCE.convertList02(list));
    }

    /**
     * 发送短信
     * @param sendReqVO
     * @return
     */
    @PostMapping("/send-mail")
    @PreAuthorize("@ss.hasPermission('system:mail-template:send-mail')")
    public CommonResult<Long> sendMail(@Valid @RequestBody MailTemplateSendReqVO sendReqVO) {
        return success(mailSendService.sendSingleMailToAdmin(sendReqVO.getMail(), null,
                sendReqVO.getTemplateCode(), sendReqVO.getTemplateParams()));
    }

}
