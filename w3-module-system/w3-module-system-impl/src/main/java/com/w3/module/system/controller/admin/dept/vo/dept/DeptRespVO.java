package com.w3.module.system.controller.admin.dept.vo.dept;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 管理后台 - 部门信息 Response VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptRespVO extends DeptBaseVO {

    /**
     * 部门编号 example = "1024"
     */
    private Long id;

    /**
     * 状态,参见 CommonStatusEnum 枚举类 example = "1"
     */
    private Integer status;

    /**
     * 创建时间  example = "时间戳格式"
     */
    private LocalDateTime createTime;

}
