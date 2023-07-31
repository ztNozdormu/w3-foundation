package com.knd.module.system.single.controller.admin.oauth2.vo.token;

import com.knd.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description = "管理后台 - 访问令牌分页 Request VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OAuth2AccessTokenPageReqVO extends PageParam {

    /**
     * description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "666"
     */
    private Long userId;

    /**
     * description = "用户类型,参见 UserTypeEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "2"
     */
    private Integer userType;

    /**
     * description = "客户端编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2"
     */
    private String clientId;

}
