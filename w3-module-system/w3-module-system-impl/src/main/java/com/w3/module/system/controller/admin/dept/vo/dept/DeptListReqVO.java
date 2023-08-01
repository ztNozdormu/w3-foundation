package com.w3.module.system.controller.admin.dept.vo.dept;

import lombok.Data;

/**
 * 管理后台 - 部门列表 Request VO
 */
@Data
public class DeptListReqVO {

    /**
     * 部门名称,模糊匹配 example = "芋道"
     */
    private String name;

    /**
     * 展示状态,参见 CommonStatusEnum 枚举类 example = "1"
     */
    private Integer status;

}
