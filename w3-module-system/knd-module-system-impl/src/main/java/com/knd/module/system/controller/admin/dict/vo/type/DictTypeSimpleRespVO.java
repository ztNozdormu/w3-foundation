package com.knd.module.system.controller.admin.dict.vo.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description = "管理后台 - 字典类型精简信息 Response VO"
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictTypeSimpleRespVO {

    /**
     * description = "字典类型编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    private Long id;

    /**
     * description = "字典类型名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋道"
     */
    private String name;

    /**
     * description = "字典类型", example = "sys_common_sex"
     */
    private String type;

}
