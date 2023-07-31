package com.knd.module.system.controller.admin.dict.vo.type;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.knd.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * description = "管理后台 - 字典类型分页列表 Request VO"
 */
@Data
public class DictTypeExportReqVO {

    /**
     * description = "字典类型名称,模糊匹配", example = "芋道"
     */
    private String name;

    /**
     * description = "字典类型,模糊匹配", example = "sys_common_sex"
     */
    private String type;

    /**
     * description = "展示状态,参见 CommonStatusEnum 枚举类", example = "1"
     */
    private Integer status;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
