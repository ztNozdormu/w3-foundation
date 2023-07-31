package com.knd.module.system.single.controller.admin.socail;


import com.knd.framework.common.enums.UserTypeEnum;
import com.knd.framework.common.pojo.CommonResult;
import com.knd.module.system.convert.social.SocialUserConvert;
import com.knd.module.system.service.social.SocialUserService;
import com.knd.module.system.single.controller.admin.socail.vo.SocialUserBindReqVO;
import com.knd.module.system.single.controller.admin.socail.vo.SocialUserUnbindReqVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.knd.framework.web.core.util.WebFrameworkUtils.getLoginUserId;


/**
 * 管理后台 - 社交用户
 */
@RestController
@RequestMapping("/system/social-user")
@Validated
public class SocialUserController {

    @Resource
    private SocialUserService socialUserService;

    /**
     * 社交绑定，使用 code 授权码
     * @param reqVO
     * @return
     */
    @PostMapping("/bind")
    public CommonResult<Boolean> socialBind(@RequestBody @Valid SocialUserBindReqVO reqVO) {
        socialUserService.bindSocialUser(SocialUserConvert.INSTANCE.convert(getLoginUserId(), UserTypeEnum.ADMIN.getValue(), reqVO));
        return CommonResult.success(true);
    }

    /**
     * 取消社交绑定
     * @param reqVO
     * @return
     */
    @DeleteMapping("/unbind")
    public CommonResult<Boolean> socialUnbind(@RequestBody SocialUserUnbindReqVO reqVO) {
        socialUserService.unbindSocialUser(getLoginUserId(), UserTypeEnum.ADMIN.getValue(), reqVO.getType(), reqVO.getOpenid());
        return CommonResult.success(true);
    }

}
