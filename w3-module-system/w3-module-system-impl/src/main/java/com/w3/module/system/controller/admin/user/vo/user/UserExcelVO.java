package com.w3.module.system.controller.admin.user.vo.user;

import com.alibaba.excel.annotation.ExcelProperty;
import com.w3.framework.excel.core.annotations.DictFormat;
import com.w3.framework.excel.core.convert.DictConvert;
import com.w3.module.system.enums.DictTypeConstants;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户 Excel 导出 VO
 */
@Data
public class UserExcelVO {

    @ExcelProperty("用户编号")
    private Long id;

    @ExcelProperty("用户名称")
    private String username;

    @ExcelProperty("用户昵称")
    private String nickname;

    @ExcelProperty("用户邮箱")
    private String email;

    @ExcelProperty("手机号码")
    private String mobile;

    @ExcelProperty(value = "用户性别", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.USER_SEX)
    private Integer sex;

    @ExcelProperty(value = "帐号状态", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @ExcelProperty("最后登录IP")
    private String loginIp;

    @ExcelProperty("最后登录时间")
    private LocalDateTime loginDate;

    @ExcelProperty("部门名称")
    private String deptName;

    @ExcelProperty("部门负责人")
    private String deptLeaderNickname;

}
