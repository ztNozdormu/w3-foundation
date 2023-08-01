package com.w3.module.system.controller.admin.socail.vo;


import com.w3.framework.common.validation.InEnum;
import com.w3.module.system.enums.social.SocialTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 管理后台 - 取消社交绑定 Request VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SocialUserUnbindReqVO {

    /**
     * description = "社交平台的类型,参见 UserSocialTypeEnum 枚举值", requiredMode = Schema.RequiredMode.REQUIRED, example = "10"
     */
    @InEnum(SocialTypeEnum.class)
    @NotNull(message = "社交平台的类型不能为空")
    private Integer type;

    /**
     * description = "社交用户的 openid", example = "IPRmJ0wvBptiPIlGEZiPewGwiEiE"
     */
    @NotEmpty(message = "社交用户的 openid 不能为空")
    private String openid;

}
