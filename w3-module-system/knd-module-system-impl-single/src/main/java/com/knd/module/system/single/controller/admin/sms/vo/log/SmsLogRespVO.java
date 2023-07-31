package com.knd.module.system.single.controller.admin.sms.vo.log;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * description = "管理后台 - 短信日志 Response VO"
 */
@Data
public class SmsLogRespVO {

    /**
     * description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    private Long id;

    /**
     * description = "短信渠道编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "10"
     */
    private Long channelId;

    /**
     * description = "短信渠道编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "ALIYUN"
     */
    private String channelCode;

    /**
     * description = "模板编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "20"
     */
    private Long templateId;

    /**
     * description = "模板编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "test-01"
     */
    private String templateCode;

    /**
     * description = "短信类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
     */
    private Integer templateType;

    /**
     * description = "短信内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "你好，你的验证码是 1024"
     */
    private String templateContent;

    /**
     * description = "短信参数", requiredMode = Schema.RequiredMode.REQUIRED, example = "name,code"
     */
    private Map<String, Object> templateParams;

    /**
     * description = "短信 API 的模板编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "SMS_207945135"
     */
    private String apiTemplateId;

    /**
     * description = "手机号", requiredMode = Schema.RequiredMode.REQUIRED, example = "15601691300"
     */
    private String mobile;

    /**
     * description = "用户编号", example = "10"
     */
    private Long userId;

    /**
     * description = "用户类型", example = "1"
     */
    private Integer userType;

    /**
     * description = "发送状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
     */
    private Integer sendStatus;

    /**
     * description = "发送时间"
     */
    private LocalDateTime sendTime;

    /**
     * description = "发送结果的编码", example = "0"
     */
    private Integer sendCode;

    /**
     * description = "发送结果的提示", example = "成功"
     */
    private String sendMsg;

    /**
     * description = "短信 API 发送结果的编码", example = "SUCCESS"
     */
    private String apiSendCode;

    /**
     * description = "短信 API 发送失败的提示", example = "成功"
     */
    private String apiSendMsg;

    /**
     * description = "短信 API 发送返回的唯一请求 ID", example = "3837C6D3-B96F-428C-BBB2-86135D4B5B99"
     */
    private String apiRequestId;

    /**
     * description = "短信 API 发送返回的序号", example = "62923244790"
     */
    private String apiSerialNo;

    /**
     * description = "接收状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0"
     */
    private Integer receiveStatus;

    /**
     * description = "接收时间"
     */
    private LocalDateTime receiveTime;

    /**
     * description = "API 接收结果的编码", example = "DELIVRD"
     */
    private String apiReceiveCode;

    /**
     * description = "API 接收结果的说明", example = "用户接收成功"
     */
    private String apiReceiveMsg;

    /**
     * description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED
     */
    private LocalDateTime createTime;

}
