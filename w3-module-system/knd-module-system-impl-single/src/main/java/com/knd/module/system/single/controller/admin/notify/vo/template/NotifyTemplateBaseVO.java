package com.knd.module.system.single.controller.admin.notify.vo.template;

import com.knd.framework.common.enums.CommonStatusEnum;
import com.knd.framework.common.validation.InEnum;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 站内信模版 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class NotifyTemplateBaseVO {

    /**
     * description = "模版名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "测试模版"
     */
    @NotEmpty(message = "模版名称不能为空")
    private String name;

    /**
     * description = "模版编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "SEND_TEST"
     */
    @NotNull(message = "模版编码不能为空")
    private String code;

    /**
     * description = "模版类型 - 对应 system_notify_template_type 字典", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
     */
    @NotNull(message = "模版类型不能为空")
    private Integer type;

    /**
     * description = "发送人名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "土豆"
     */
    @NotEmpty(message = "发送人名称不能为空")
    private String nickname;

    /**
     * description = "模版内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "我是模版内容"
     */
    @NotEmpty(message = "模版内容不能为空")
    private String content;

    /**
     * description = "状态 - 参见 CommonStatusEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
     */
    @NotNull(message = "状态不能为空")
    @InEnum(value = CommonStatusEnum.class, message = "状态必须是 {value}")
    private Integer status;

    /**
     * description = "备注", example = "我是备注"
     */
    private String remark;

}
