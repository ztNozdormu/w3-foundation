package com.w3.module.system.controller.admin.user.vo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/**
 * description = "管理后台 - 用户信息 Response VO"
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserRespVO extends UserBaseVO {

    /**
     * description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
     */
    private Long id;

    /**
     * description = "状态,参见 CommonStatusEnum 枚举类", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
     */
    private Integer status;

    /**
     * description = "最后登录 IP", requiredMode = Schema.RequiredMode.REQUIRED, example = "192.168.1.1"
     */
    private String loginIp;

    /**
     * description = "最后登录时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "时间戳格式"
     */
    private LocalDateTime loginDate;

    /**
     * description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "时间戳格式"
     */
    private LocalDateTime createTime;

}
