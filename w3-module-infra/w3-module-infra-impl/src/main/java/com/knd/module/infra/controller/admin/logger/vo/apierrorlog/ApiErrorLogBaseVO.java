package com.w3.module.infra.controller.admin.logger.vo.apierrorlog;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static com.w3.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
* API 错误日志 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ApiErrorLogBaseVO {

    /**
     * 链路追踪编号  example = "66600cb6-7852-11eb-9439-0242ac130002"
     */
    @NotNull(message = "链路追踪编号不能为空")
    private String traceId;

    /**
     * 用户编号 example = "666"
     */
    @NotNull(message = "用户编号不能为空")
    private Integer userId;

    /**
     * 用户类型 example = "1"
     */
    @NotNull(message = "用户类型不能为空")
    private Integer userType;

    /**
     * 应用名 example = "dashboard"
     */
    @NotNull(message = "应用名不能为空")
    private String applicationName;

    /**
     * 请求方法名 example = "GET"
     */
    @NotNull(message = "请求方法名不能为空")
    private String requestMethod;

    /**
     * 请求地址 example = "/xx/yy"
     */
    @NotNull(message = "请求地址不能为空")
    private String requestUrl;

    /**
     * 请求参数
     */
    @NotNull(message = "请求参数不能为空")
    private String requestParams;

    /**
     * 用户 IP example = "127.0.0.1"
     */
    @NotNull(message = "用户 IP不能为空")
    private String userIp;

    /**
     * 浏览器 UA example = "Mozilla/5.0"
     */
    @NotNull(message = "浏览器 UA不能为空")
    private String userAgent;

    /**
     * 异常发生时间
     */
    @NotNull(message = "异常发生时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime exceptionTime;

    /**
     * 异常名
     */
    @NotNull(message = "异常名不能为空")
    private String exceptionName;

    /**
     * 异常导致的消息
     */
    @NotNull(message = "异常导致的消息不能为空")
    private String exceptionMessage;

    /**
     * 异常导致的根消息
     */
    @NotNull(message = "异常导致的根消息不能为空")
    private String exceptionRootCauseMessage;

    /**
     * 异常的栈轨迹
     */
    @NotNull(message = "异常的栈轨迹不能为空")
    private String exceptionStackTrace;

    /**
     * 异常发生的类全名
     */
    @NotNull(message = "异常发生的类全名不能为空")
    private String exceptionClassName;

    /**
     * 异常发生的类文件
     */
    @NotNull(message = "异常发生的类文件不能为空")
    private String exceptionFileName;

    /**
     * 异常发生的方法名
     */
    @NotNull(message = "异常发生的方法名不能为空")
    private String exceptionMethodName;

    /**
     * 异常发生的方法所在行
     */
    @NotNull(message = "异常发生的方法所在行不能为空")
    private Integer exceptionLineNumber;

    /**
     * 处理状态
     */
    @NotNull(message = "处理状态不能为空")
    private Integer processStatus;

}
