package com.w3.module.infra.controller.admin.codegen.vo.column;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
* 代码生成字段定义 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CodegenColumnBaseVO {

    /**
     * 表编号 example = "1"
     */
    @NotNull(message = "表编号不能为空")
    private Long tableId;

    /**
     * 字段名 example = "user_age"
     */
    @NotNull(message = "字段名不能为空")
    private String columnName;

    /**
     * 字段类型 example = "int(11)"
     */
    @NotNull(message = "字段类型不能为空")
    private String dataType;

    /**
     * 字段描述 example = "年龄"
     */
    @NotNull(message = "字段描述不能为空")
    private String columnComment;

    /**
     * 是否允许为空 example = "true"
     */
    @NotNull(message = "是否允许为空不能为空")
    private Boolean nullable;

    /**
     * 是否主键 example = "false"
     */
    @NotNull(message = "是否主键不能为空")
    private Boolean primaryKey;

    /**
     * 是否自增 example = "true"
     */
    @NotNull(message = "是否自增不能为空")
    private String autoIncrement;

    /**
     * 排序 example = "10"
     */
    @NotNull(message = "排序不能为空")
    private Integer ordinalPosition;

    /**
     * Java 属性类型 example = "userAge"
     */
    @NotNull(message = "Java 属性类型不能为空")
    private String javaType;

    /**
     * Java 属性名  example = "Integer"
     */
    @NotNull(message = "Java 属性名不能为空")
    private String javaField;

    /**
     * 字典类型 example = "sys_gender"
     */
    private String dictType;

    /**
     * 数据示例 example = "1024"
     */
    private String example;

    /**
     * 是否为 Create 创建操作的字段  example = "true"
     */
    @NotNull(message = "是否为 Create 创建操作的字段不能为空")
    private Boolean createOperation;

    /**
     * 是否为 Update 更新操作的字段  example = "false"
     */
    @NotNull(message = "是否为 Update 更新操作的字段不能为空")
    private Boolean updateOperation;

    /**
     * 是否为 List 查询操作的字段 example = "true"
     */
    @NotNull(message = "是否为 List 查询操作的字段不能为空")
    private Boolean listOperation;

    /**
     * List 查询操作的条件类型,参见 CodegenColumnListConditionEnum 枚举 example = "LIKE"
     */
    @NotNull(message = "List 查询操作的条件类型不能为空")
    private String listOperationCondition;

    /**
     * 是否为 List 查询操作的返回字段  example = "true"
     */
    @NotNull(message = "是否为 List 查询操作的返回字段不能为空")
    private Boolean listOperationResult;

    /**
     * 显示类型  example = "input"
     */
    @NotNull(message = "显示类型不能为空")
    private String htmlType;

}
