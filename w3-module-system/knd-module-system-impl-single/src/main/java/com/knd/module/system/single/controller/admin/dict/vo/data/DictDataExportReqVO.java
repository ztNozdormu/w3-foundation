package com.knd.module.system.single.controller.admin.dict.vo.data;

import lombok.Data;

import javax.validation.constraints.Size;

/**
 * description = "管理后台 - 字典类型导出 Request VO"
 */
@Data
public class DictDataExportReqVO {

    /**
     * description = "字典标签", example = "芋道"
     */
    @Size(max = 100, message = "字典标签长度不能超过100个字符")
    private String label;

    /**
     * description = "字典类型,模糊匹配", example = "sys_common_sex"
     */
    @Size(max = 100, message = "字典类型类型长度不能超过100个字符")
    private String dictType;

    /**
     * description = "展示状态,参见 CommonStatusEnum 枚举类", example = "1"
     */
    private Integer status;

}
