package com.knd.module.system.single.controller.admin.permission.vo.menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 管理后台 - 菜单信息 Response VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MenuRespVO extends MenuBaseVO {

    /**
     * description = "菜单编号",  example = "1024"
     */
    private Long id;

    /**
     * description = "状态,参见 CommonStatusEnum 枚举类",  example = "1"
     */
    private Integer status;

    /**
     * description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "时间戳格式"
     */
    private LocalDateTime createTime;

}
