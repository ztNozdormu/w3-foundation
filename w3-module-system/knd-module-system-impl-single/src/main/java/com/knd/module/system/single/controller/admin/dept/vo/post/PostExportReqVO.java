package com.knd.module.system.single.controller.admin.dept.vo.post;

import lombok.Data;

/**
 * 管理后台 - 岗位导出 Request VO,参数和 PostExcelVO 是一致的
 */
@Data
public class PostExportReqVO {

    /**
     * description = "岗位编码,模糊匹配", example = "yudao"
     */
    private String code;

    /**
     * description = "岗位名称,模糊匹配", example = "芋道"
     */
    private String name;

    /**
     * description = "展示状态,参见 CommonStatusEnum 枚举类", example = "1"
     */
    private Integer status;

}
