package com.w3.module.system.controller.admin.user.vo.profile;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


/**
 * description = "管理后台 - 用户个人信息更新 Request VO"
 */
@Data
public class UserProfileUpdateReqVO {

    /**
     * description = "用户昵称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿"
     */
    @Size(max = 30, message = "用户昵称长度不能超过 30 个字符")
    private String nickname;

    /**
     * description = "用户邮箱", example = "yudao@iocoder.cn"
     */
    @Email(message = "邮箱格式不正确")
    @Size(max = 50, message = "邮箱长度不能超过 50 个字符")
    private String email;

    /**
     * description = "手机号码", example = "15601691300"
     */
    private String mobile;

    /**
     * description = "用户性别-参见 SexEnum 枚举类", example = "1"
     */
    private Integer sex;

}
