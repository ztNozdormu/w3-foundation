package com.w3.module.system.controller.admin.permission.vo.role;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 角色 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class RoleBaseVO {

    /**
     * description = "角色名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "管理员"
     */
    @NotBlank(message = "角色名称不能为空")
    @Size(max = 30, message = "角色名称长度不能超过30个字符")
    private String name;

    /**
     * description = "角色编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "ADMIN"
     */
    @NotBlank(message = "角色标志不能为空")
    @Size(max = 100, message = "角色标志长度不能超过100个字符")
    private String code;

    /**
     * description = "显示顺序不能为空",  example = "1024"
     */
    @NotNull(message = "显示顺序不能为空")
    private Integer sort;

    /**
     * description = "备注", example = "我是一个角色"
     */
    private String remark;

}
