package com.w3.module.system.controller.admin.dict.vo.data;

import com.w3.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Size;

/**
 * 管理后台 - 字典类型分页列表 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DictDataPageReqVO extends PageParam {

    /**
     * 字典标签 example = "芋道"
     */
    @Size(max = 100, message = "字典标签长度不能超过100个字符")
    private String label;

    /**
     * 字典类型,模糊匹配 example = "sys_common_sex"
     */
    @Size(max = 100, message = "字典类型类型长度不能超过100个字符")
    private String dictType;

    /**
     * 展示状态,参见 CommonStatusEnum 枚举类 example = "1"
     */
    private Integer status;

}
