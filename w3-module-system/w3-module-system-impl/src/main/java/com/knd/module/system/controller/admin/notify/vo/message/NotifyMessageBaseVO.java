package com.w3.module.system.controller.admin.notify.vo.message;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Map;

import static com.w3.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * 站内信消息 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class NotifyMessageBaseVO {

    /**
     * description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "25025"
     */
    @NotNull(message = "用户编号不能为空")
    private Long userId;

    /**
     * description = "用户类型 - 参见 UserTypeEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
     */
    @NotNull(message = "用户类型不能为空")
    private Byte userType;

    /**
     * description = "模版编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "13013"
     */
    @NotNull(message = "模版编号不能为空")
    private Long templateId;

    /**
     * description = "模板编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "test_01"
     */
    @NotNull(message = "模板编码不能为空")
    private String templateCode;

    /**
     * description = "模版发送人名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿"
     */
    @NotNull(message = "模版发送人名称不能为空")
    private String templateNickname;

    /**
     * description = "模版内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "测试内容"
     */
    @NotNull(message = "模版内容不能为空")
    private String templateContent;

    /**
     * description = "模版类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "2"
     */
    @NotNull(message = "模版类型不能为空")
    private Integer templateType;

    /**
     * description = "模版参数", requiredMode = Schema.RequiredMode.REQUIRED
     */
    @NotNull(message = "模版参数不能为空")
    private Map<String, Object> templateParams;

    /**
     * description = "是否已读", requiredMode = Schema.RequiredMode.REQUIRED, example = "true"
     */
    @NotNull(message = "是否已读不能为空")
    private Boolean readStatus;

    /**
     * description = "阅读时间"
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime readTime;

}
