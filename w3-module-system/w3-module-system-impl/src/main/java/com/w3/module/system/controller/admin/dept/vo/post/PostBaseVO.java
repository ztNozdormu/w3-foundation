package com.w3.module.system.controller.admin.dept.vo.post;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 岗位 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class PostBaseVO {

    /**
     * "岗位名称",  example = "小博主"
     */
    @NotBlank(message = "岗位名称不能为空")
    @Size(max = 50, message = "岗位名称长度不能超过50个字符")
    private String name;

    /**
     *  "岗位编码", example = "yudao"
     */
    @NotBlank(message = "岗位编码不能为空")
    @Size(max = 64, message = "岗位编码长度不能超过64个字符")
    private String code;

    /**
     * "显示顺序不能为空", example = "1024"
     */
    @NotNull(message = "显示顺序不能为空")
    private Integer sort;

    /**
     *  "状态,参见 CommonStatusEnum 枚举类",  example = "1"
     */
    private Integer status;

    /**
     * "备注", example = "快乐的备注"
     */
    private String remark;

}
