package com.knd.module.system.controller.admin.oauth2;


import com.knd.framework.common.pojo.CommonResult;
import com.knd.framework.common.pojo.PageResult;
import com.knd.module.system.controller.admin.oauth2.vo.token.OAuth2AccessTokenPageReqVO;
import com.knd.module.system.controller.admin.oauth2.vo.token.OAuth2AccessTokenRespVO;
import com.knd.module.system.convert.auth.OAuth2TokenConvert;
import com.knd.module.system.dal.dataobject.oauth2.OAuth2AccessTokenDO;
import com.knd.module.system.enums.logger.LoginLogTypeEnum;
import com.knd.module.system.service.auth.AdminAuthService;
import com.knd.module.system.service.oauth2.OAuth2TokenService;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.knd.framework.common.pojo.CommonResult.success;


/**
 * 管理后台 - OAuth2.0 令牌
 */
@RestController
@RequestMapping("/system/oauth2-token")
public class OAuth2TokenController {

    @Resource
    private OAuth2TokenService oauth2TokenService;
    @Resource
    private AdminAuthService authService;

    /**
     * "获得访问令牌分页", description = "只返回有效期内的"
     * @param reqVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:oauth2-token:page')")
    public CommonResult<PageResult<OAuth2AccessTokenRespVO>> getAccessTokenPage(@Valid OAuth2AccessTokenPageReqVO reqVO) {
        PageResult<OAuth2AccessTokenDO> pageResult = oauth2TokenService.getAccessTokenPage(reqVO);
        return success(OAuth2TokenConvert.INSTANCE.convert(pageResult));
    }

    /**
     * 删除访问令牌
     * @param accessToken   description = "访问令牌", required = true, example = "tudou"
     * @return
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:oauth2-token:delete')")
    public CommonResult<Boolean> deleteAccessToken(@RequestParam("accessToken") String accessToken) {
        authService.logout(accessToken, LoginLogTypeEnum.LOGOUT_DELETE.getType());
        return success(true);
    }

}
