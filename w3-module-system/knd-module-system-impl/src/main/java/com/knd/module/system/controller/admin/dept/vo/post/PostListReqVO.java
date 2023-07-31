package com.knd.module.system.controller.admin.dept.vo.post;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description = "管理后台 - 岗位列表 Request VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PostListReqVO extends PostBaseVO {

    /**
     * description = "岗位名称,模糊匹配", example = "芋道"
     */
    private String name;

    /**
     * description = "展示状态,参见 CommonStatusEnum 枚举类", example = "1"
     */
    private Integer status;

}
