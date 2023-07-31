package com.knd.module.infra.single.controller.admin.logger.vo.apiaccesslog;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static com.knd.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
* API 访问日志 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ApiAccessLogBaseVO {

    /**
     * 链路追踪编号 example = "66600cb6-7852-11eb-9439-0242ac130002"
     */
    @NotNull(message = "链路追踪编号不能为空")
    private String traceId;

    /**
     * 用户编号 example = "666"
     */
    @NotNull(message = "用户编号不能为空")
    private Long userId;

    /**
     *  用户类型,参见 UserTypeEnum 枚举 example = "2"
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
     * 请求地址 example = "/xxx/yyy"
     */
    @NotNull(message = "请求地址不能为空")
    private String requestUrl;

    /**
     * 请求参数
     */
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
     * 开始请求时间
     */
    @NotNull(message = "开始请求时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime beginTime;

    /**
     * 结束请求时间
     */
    @NotNull(message = "结束请求时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endTime;

    /**
     * 执行时长 example = "100"
     */
    @NotNull(message = "执行时长不能为空")
    private Integer duration;

    /**
     * 结果码 example = "0"
     */
    @NotNull(message = "结果码不能为空")
    private Integer resultCode;

    /**
     * 结果提示 example = "芋道源码，牛逼！"
     */
    private String resultMsg;

}
