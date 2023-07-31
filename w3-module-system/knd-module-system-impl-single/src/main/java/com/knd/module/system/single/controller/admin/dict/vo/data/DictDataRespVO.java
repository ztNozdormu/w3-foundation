package com.knd.module.system.single.controller.admin.dict.vo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * description = "管理后台 - 字典数据信息 Response VO"
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DictDataRespVO extends DictDataBaseVO {

    /**
     * description = "字典数据编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    private Long id;

    /**
     * description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "时间戳格式"
     */
    private LocalDateTime createTime;

}
