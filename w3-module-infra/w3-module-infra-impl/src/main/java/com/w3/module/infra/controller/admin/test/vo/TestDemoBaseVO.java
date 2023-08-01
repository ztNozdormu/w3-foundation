package com.w3.module.infra.controller.admin.test.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
* 字典类型 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class TestDemoBaseVO {

    /**
     * 名字
     */
    @NotNull(message = "名字不能为空")
    private String name;
    /**
     * 状态
     */
    @NotNull(message = "状态不能为空")
    private Integer status;
    /**
     * 类型
     */
    @NotNull(message = "类型不能为空")
    private Integer type;
    /**
     * 分类
     */
    @NotNull(message = "分类不能为空")
    private Integer category;
    /**
     * 备注
     */
    private String remark;

}
