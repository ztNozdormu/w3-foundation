package com.w3.module.system.controller.admin.user.vo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description = "管理后台 - 用户精简信息 Response VO"
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSimpleRespVO {

    /**
     * description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    private Long id;

    /**
     * description = "用户昵称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋道"
     */
    private String nickname;

}
