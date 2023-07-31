package com.knd.module.system.controller.admin.logger.vo.loginlog;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 登录日志 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class LoginLogBaseVO {

    /**
     * description = "日志类型,参见 LoginLogTypeEnum 枚举类", example = "1"
     */
    @NotNull(message = "日志类型不能为空")
    private Integer logType;

    /**
     * description = "链路追踪编号", example = "89aca178-a370-411c-ae02-3f0d672be4ab"
     */
    @NotEmpty(message = "链路追踪编号不能为空")
    private String traceId;

    /**
     * description = "用户账号",  example = "yudao"
     */
    @NotBlank(message = "用户账号不能为空")
    @Size(max = 30, message = "用户账号长度不能超过30个字符")
    private String username;

    /**
     * description = "登录结果,参见 LoginResultEnum 枚举类", example = "1"
     */
    @NotNull(message = "登录结果不能为空")
    private Integer result;

    /**
     * description = "用户 IP",  example = "127.0.0.1"
     */
    @NotEmpty(message = "用户 IP 不能为空")
    private String userIp;

    /**
     * description = "浏览器 UserAgent", example = "Mozilla/5.0"
     */
    private String userAgent;

}
