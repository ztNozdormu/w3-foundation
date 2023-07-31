package com.w3.module.system.controller.admin.sms;


import com.w3.framework.common.pojo.CommonResult;
import com.w3.framework.common.pojo.PageResult;
import com.w3.framework.excel.core.util.ExcelUtils;
import com.w3.framework.operatelog.core.annotations.OperateLog;
import com.w3.module.system.controller.admin.sms.vo.template.*;
import com.w3.module.system.convert.sms.SmsTemplateConvert;
import com.w3.module.system.dal.dataobject.sms.SmsTemplateDO;
import com.w3.module.system.service.sms.SmsSendService;
import com.w3.module.system.service.sms.SmsTemplateService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static com.w3.framework.common.pojo.CommonResult.success;
import static com.w3.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;


/**
 * 管理后台 - 短信模板
 */
@RestController
@RequestMapping("/system/sms-template")
public class SmsTemplateController {

    @Resource
    private SmsTemplateService smsTemplateService;
    @Resource
    private SmsSendService smsSendService;

    /**
     * 创建短信模板
     * @param createReqVO
     * @return
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:sms-template:create')")
    public CommonResult<Long> createSmsTemplate(@Valid @RequestBody SmsTemplateCreateReqVO createReqVO) {
        return success(smsTemplateService.createSmsTemplate(createReqVO));
    }

    /**
     * 更新短信模板
     * @param updateReqVO
     * @return
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:sms-template:update')")
    public CommonResult<Boolean> updateSmsTemplate(@Valid @RequestBody SmsTemplateUpdateReqVO updateReqVO) {
        smsTemplateService.updateSmsTemplate(updateReqVO);
        return success(true);
    }

    /**
     * 删除短信模板
     * @param id description = "编号", required = true
     * @return
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:sms-template:delete')")
    public CommonResult<Boolean> deleteSmsTemplate(@RequestParam("id") Long id) {
        smsTemplateService.deleteSmsTemplate(id);
        return success(true);
    }

    /**
     * 获得短信模板
     * @param id  description = "编号", required = true, example = "1024"
     * @return
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:sms-template:query')")
    public CommonResult<SmsTemplateRespVO> getSmsTemplate(@RequestParam("id") Long id) {
        SmsTemplateDO smsTemplate = smsTemplateService.getSmsTemplate(id);
        return success(SmsTemplateConvert.INSTANCE.convert(smsTemplate));
    }

    /**
     * 获得短信模板分页
     * @param pageVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:sms-template:query')")
    public CommonResult<PageResult<SmsTemplateRespVO>> getSmsTemplatePage(@Valid SmsTemplatePageReqVO pageVO) {
        PageResult<SmsTemplateDO> pageResult = smsTemplateService.getSmsTemplatePage(pageVO);
        return success(SmsTemplateConvert.INSTANCE.convertPage(pageResult));
    }

    /**
     * 导出短信模板 Excel
     * @param exportReqVO
     * @param response
     * @throws IOException
     */
    @GetMapping("/export-excel")
    @PreAuthorize("@ss.hasPermission('system:sms-template:export')")
    @OperateLog(type = EXPORT)
    public void exportSmsTemplateExcel(@Valid SmsTemplateExportReqVO exportReqVO,
                                       HttpServletResponse response) throws IOException {
        List<SmsTemplateDO> list = smsTemplateService.getSmsTemplateList(exportReqVO);
        // 导出 Excel
        List<SmsTemplateExcelVO> datas = SmsTemplateConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "短信模板.xls", "数据", SmsTemplateExcelVO.class, datas);
    }

    /**
     * 发送短信
     * @param sendReqVO
     * @return
     */
    @PostMapping("/send-sms")
    @PreAuthorize("@ss.hasPermission('system:sms-template:send-sms')")
    public CommonResult<Long> sendSms(@Valid @RequestBody SmsTemplateSendReqVO sendReqVO) {
        return success(smsSendService.sendSingleSmsToAdmin(sendReqVO.getMobile(), null,
                sendReqVO.getTemplateCode(), sendReqVO.getTemplateParams()));
    }

}
