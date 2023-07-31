package com.knd.module.system.controller.admin.oauth2;


import com.knd.framework.common.pojo.CommonResult;
import com.knd.framework.common.pojo.PageResult;
import com.knd.module.system.controller.admin.oauth2.vo.client.OAuth2ClientCreateReqVO;
import com.knd.module.system.controller.admin.oauth2.vo.client.OAuth2ClientPageReqVO;
import com.knd.module.system.controller.admin.oauth2.vo.client.OAuth2ClientRespVO;
import com.knd.module.system.controller.admin.oauth2.vo.client.OAuth2ClientUpdateReqVO;
import com.knd.module.system.convert.auth.OAuth2ClientConvert;
import com.knd.module.system.dal.dataobject.oauth2.OAuth2ClientDO;
import com.knd.module.system.service.oauth2.OAuth2ClientService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.knd.framework.common.pojo.CommonResult.success;


/**
 * 管理后台 - OAuth2 客户端
 */
@RestController
@RequestMapping("/system/oauth2-client")
@Validated
public class OAuth2ClientController {

    @Resource
    private OAuth2ClientService oAuth2ClientService;

    /**
     * 创建 OAuth2 客户端
     * @param createReqVO
     * @return
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:oauth2-client:create')")
    public CommonResult<Long> createOAuth2Client(@Valid @RequestBody OAuth2ClientCreateReqVO createReqVO) {
        return success(oAuth2ClientService.createOAuth2Client(createReqVO));
    }

    /**
     * 更新 OAuth2 客户端
     * @param updateReqVO
     * @return
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:oauth2-client:update')")
    public CommonResult<Boolean> updateOAuth2Client(@Valid @RequestBody OAuth2ClientUpdateReqVO updateReqVO) {
        oAuth2ClientService.updateOAuth2Client(updateReqVO);
        return success(true);
    }

    /**
     * 删除 OAuth2 客户端
     * @param id description = "编号", required = true
     * @return
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:oauth2-client:delete')")
    public CommonResult<Boolean> deleteOAuth2Client(@RequestParam("id") Long id) {
        oAuth2ClientService.deleteOAuth2Client(id);
        return success(true);
    }

    /**
     * 获得 OAuth2 客户端
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:oauth2-client:query')")
    public CommonResult<OAuth2ClientRespVO> getOAuth2Client(@RequestParam("id") Long id) {
        OAuth2ClientDO oAuth2Client = oAuth2ClientService.getOAuth2Client(id);
        return success(OAuth2ClientConvert.INSTANCE.convert(oAuth2Client));
    }

    /**
     * 获得OAuth2 客户端分页
     * @param pageVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:oauth2-client:query')")
    public CommonResult<PageResult<OAuth2ClientRespVO>> getOAuth2ClientPage(@Valid OAuth2ClientPageReqVO pageVO) {
        PageResult<OAuth2ClientDO> pageResult = oAuth2ClientService.getOAuth2ClientPage(pageVO);
        return success(OAuth2ClientConvert.INSTANCE.convertPage(pageResult));
    }

}
