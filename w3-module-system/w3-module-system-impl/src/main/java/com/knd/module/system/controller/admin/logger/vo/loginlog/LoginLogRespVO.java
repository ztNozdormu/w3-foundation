package com.w3.module.system.controller.admin.logger.vo.loginlog;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * 管理后台 - 登录日志 Response VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LoginLogRespVO extends LoginLogBaseVO {

    /**
     * description = "日志编号",  example = "1024"
     */
    private Long id;

    /**
     * description = "用户编号", example = "666"
     */
    private Long userId;

    /**
     * description = "用户类型,参见 UserTypeEnum 枚举",  example = "2"
     */
    @NotNull(message = "用户类型不能为空")
    private Integer userType;

    /**
     * description = "登录时间"
     */
    private LocalDateTime createTime;

}
