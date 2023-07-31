package com.knd.module.system.single.controller.admin.dict.vo.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * description = "管理后台 - 字典类型信息 Response VO"
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DictTypeRespVO extends DictTypeBaseVO {

    /**
     * description = "字典类型编号",  example = "1024"
     */
    private Long id;

    /**
     * description = "字典类型", example = "sys_common_sex"
     */
    private String type;

    /**
     * description = "创建时间",  example = "时间戳格式"
     */
    private LocalDateTime createTime;

}
