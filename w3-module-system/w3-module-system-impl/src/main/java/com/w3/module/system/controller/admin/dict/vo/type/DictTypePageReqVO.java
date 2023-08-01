package com.w3.module.system.controller.admin.dict.vo.type;

import com.w3.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

import static com.w3.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * 管理后台 - 字典类型分页列表 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DictTypePageReqVO extends PageParam {

    /**
     * 字典类型名称,模糊匹配 example = "芋道"
     */
    private String name;

    /**
     * 字典类型,模糊匹配 example = "sys_common_sex"
     */
    @Size(max = 100, message = "字典类型类型长度不能超过100个字符")
    private String type;

    /**
     * 展示状态,参见 CommonStatusEnum 枚举类 example = "1"
     */
    private Integer status;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
