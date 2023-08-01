package com.w3.module.system.controller.admin.errorcode.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * description = "管理后台 - 错误码 Response VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErrorCodeRespVO extends ErrorCodeBaseVO {

    /**
     * description = "错误码编号",  example = "1024"
     */
    private Long id;

    /**
     * description = "错误码类型,参见 ErrorCodeTypeEnum 枚举类", example = "1"
     */
    private Integer type;

    /**
     * description = "创建时间"
     */
    private LocalDateTime createTime;

}
