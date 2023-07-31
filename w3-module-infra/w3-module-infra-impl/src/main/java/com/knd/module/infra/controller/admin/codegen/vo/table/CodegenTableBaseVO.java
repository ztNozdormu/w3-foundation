package com.w3.module.infra.controller.admin.codegen.vo.table;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 代码生成 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class CodegenTableBaseVO {

    /**
     * 生成场景,参见 CodegenSceneEnum 枚举  example = "1"
     */
    @NotNull(message = "导入类型不能为空")
    private Integer scene;

    /**
     * 表名称 example = "yudao"
     */
    @NotNull(message = "表名称不能为空")
    private String tableName;

    /**
     * 表描述 example = "芋道"
     */
    @NotNull(message = "表描述不能为空")
    private String tableComment;

    /**
     * 备注 example = "我是备注"
     */
    private String remark;

    /**
     * 模块名 example = "system"
     */
    @NotNull(message = "模块名不能为空")
    private String moduleName;

    /**
     * 业务名 example = "codegen"
     */
    @NotNull(message = "业务名不能为空")
    private String businessName;

    /**
     * 类名称 example = "CodegenTable"
     */
    @NotNull(message = "类名称不能为空")
    private String className;

    /**
     * 类描述 example = "代码生成器的表定义"
     */
    @NotNull(message = "类描述不能为空")
    private String classComment;

    /**
     * 作者 example = "芋道源码"
     */
    @NotNull(message = "作者不能为空")
    private String author;

    /**
     * 模板类型，参见 CodegenTemplateTypeEnum 枚举 example = "1"
     */
    @NotNull(message = "模板类型不能为空")
    private Integer templateType;

    /**
     * 前端类型，参见 CodegenFrontTypeEnum 枚举 example = "20"
     */
    @NotNull(message = "前端类型不能为空")
    private Integer frontType;

    /**
     * 父菜单编号  example = "1024"
     */
    private Long parentMenuId;

}
