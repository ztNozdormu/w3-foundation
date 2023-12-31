package com.w3.module.system.controller.admin.errorcode.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.w3.framework.excel.core.annotations.DictFormat;
import com.w3.framework.excel.core.convert.DictConvert;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 错误码 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ErrorCodeExcelVO {

    @ExcelProperty("错误码编号")
    private Long id;

    @ExcelProperty(value = "错误码类型", converter = DictConvert.class)
    @DictFormat("inf_error_code_type") // TODO 芋艿：得思考下杂解决枚举值
    private Integer type;

    @ExcelProperty("应用名")
    private String applicationName;

    @ExcelProperty("错误码编码")
    private Integer code;

    @ExcelProperty("错误码错误提示")
    private String message;

    @ExcelProperty("备注")
    private String memo;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
