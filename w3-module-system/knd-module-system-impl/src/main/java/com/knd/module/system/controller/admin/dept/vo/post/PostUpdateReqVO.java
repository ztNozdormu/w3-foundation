package com.knd.module.system.controller.admin.dept.vo.post;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * description = "管理后台 - 岗位更新 Request VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PostUpdateReqVO extends PostBaseVO {

    /**
     * description = "岗位编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    @NotNull(message = "岗位编号不能为空")
    private Long id;

}
