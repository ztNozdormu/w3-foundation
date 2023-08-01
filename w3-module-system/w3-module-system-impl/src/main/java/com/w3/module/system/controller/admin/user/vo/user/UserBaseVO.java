package com.w3.module.system.controller.admin.user.vo.user;

import com.w3.framework.common.validation.Mobile;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * 用户 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class UserBaseVO {

    /**
     * description = "用户账号", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao"
     */
    @NotBlank(message = "用户账号不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{4,30}$", message = "用户账号由 数字、字母 组成")
    @Size(min = 4, max = 30, message = "用户账号长度为 4-30 个字符")
    private String username;

    /**
     * description = "用户昵称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿"
     */
    @Size(max = 30, message = "用户昵称长度不能超过30个字符")
    private String nickname;

    /**
     * description = "备注", example = "我是一个用户"
     */
    private String remark;

    /**
     * description = "部门ID", example = "我是一个用户"
     */
    private Long deptId;

    /**
     * description = "岗位编号数组", example = "1"
     */
    private Set<Long> postIds;

    /**
     * description = "用户邮箱", example = "yudao@iocoder.cn"
     */
    @Email(message = "邮箱格式不正确")
    @Size(max = 50, message = "邮箱长度不能超过 50 个字符")
    private String email;

    /**
     * description = "手机号码", example = "15601691300"
     */
    @Mobile
    private String mobile;

    /**
     * description = "用户性别,参见 SexEnum 枚举类", example = "1"
     */
    private Integer sex;

    /**
     * description = "用户头像", example = "https://www.iocoder.cn/xxx.png"
     */
    private String avatar;
}
