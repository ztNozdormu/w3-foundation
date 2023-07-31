package com.w3.module.system.controller.admin.sms;


import com.w3.framework.common.pojo.CommonResult;
import com.w3.framework.common.util.servlet.ServletUtils;
import com.w3.framework.operatelog.core.annotations.OperateLog;
import com.w3.framework.sms.core.enums.SmsChannelEnum;
import com.w3.module.system.service.sms.SmsSendService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;

import static com.w3.framework.common.pojo.CommonResult.success;


/**
 * 管理后台 - 短信回调
 */
@RestController
@RequestMapping("/system/sms/callback")
public class SmsCallbackController {

    @Resource
    private SmsSendService smsSendService;

    /**
     * 阿里云短信的回调   description = "参见 https://help.aliyun.com/document_detail/120998.html 文档"
     * @param request
     * @return
     * @throws Throwable
     */
    @PostMapping("/aliyun")
    @PermitAll
    @OperateLog(enable = false)
    public CommonResult<Boolean> receiveAliyunSmsStatus(HttpServletRequest request) throws Throwable {
        String text = ServletUtils.getBody(request);
        smsSendService.receiveSmsStatus(SmsChannelEnum.ALIYUN.getCode(), text);
        return success(true);
    }

    /**
     * 腾讯云短信的回调  description = "参见 https://cloud.tencent.com/document/product/382/52077 文档"
     * @param request
     * @return
     * @throws Throwable
     */
    @PostMapping("/tencent")
    @PermitAll
    @OperateLog(enable = false)
    public CommonResult<Boolean> receiveTencentSmsStatus(HttpServletRequest request) throws Throwable {
        String text = ServletUtils.getBody(request);
        smsSendService.receiveSmsStatus(SmsChannelEnum.TENCENT.getCode(), text);
        return success(true);
    }

}
