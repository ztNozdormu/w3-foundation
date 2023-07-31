package com.knd.module.system.single.controller.admin.sensitiveword.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
* 敏感词 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class SensitiveWordBaseVO {

    /**
     * description = "敏感词",  example = "敏感词"
     */
    @NotNull(message = "敏感词不能为空")
    private String name;

    /**
     * description = "标签",  example = "短信,评论"
     */
    @NotNull(message = "标签不能为空")
    private List<String> tags;

    /**
     * description = "状态,参见 CommonStatusEnum 枚举类", example = "1"
     */
    @NotNull(message = "状态不能为空")
    private Integer status;

    /**
     * description = "描述", example = "污言秽语"
     */
    private String description;

}
