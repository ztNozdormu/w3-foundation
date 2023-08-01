package com.w3.module.system.controller.admin.dept.vo.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description = "管理后台 - 岗位精简信息 Response VO"
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostSimpleRespVO {

    /**
     * description = "岗位编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    private Long id;

    /**
     * description = "岗位名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋道"
     */
    private String name;

}
