package com.knd.module.system.controller.admin.dict.vo.data;

import lombok.Data;

/**
 * description = "管理后台 - 数据字典精简 Response VO"
 */
@Data
public class DictDataSimpleRespVO {

    /**
     * description = "字典类型", example = "gender"
     */
    private String dictType;

    /**
     * description = "字典键值",  example = "1"
     */
    private String value;

    /**
     * description = "字典标签",  example = "男"
     */
    private String label;

    /**
     * description = "颜色类型,default、primary、success、info、warning、danger", example = "default"
     */
    private String colorType;
    /**
     * description = "css 样式", example = "btn-visible"
     */
    private String cssClass;

}
