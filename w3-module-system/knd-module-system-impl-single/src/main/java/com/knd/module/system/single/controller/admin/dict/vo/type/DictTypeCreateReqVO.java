package com.knd.module.system.single.controller.admin.dict.vo.type;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * description = "管理后台 - 字典类型创建 Request VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DictTypeCreateReqVO extends DictTypeBaseVO {

    /**
     * description = "字典类型", example = "sys_common_sex"
     */
    @NotNull(message = "字典类型不能为空")
    @Size(max = 100, message = "字典类型类型长度不能超过100个字符")
    private String type;

}
