package com.knd.module.system.controller.admin.mail;



import com.knd.framework.common.pojo.CommonResult;
import com.knd.framework.common.pojo.PageResult;
import com.knd.module.system.controller.admin.mail.vo.account.*;
import com.knd.module.system.convert.mail.MailAccountConvert;
import com.knd.module.system.dal.dataobject.mail.MailAccountDO;
import com.knd.module.system.service.mail.MailAccountService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static com.knd.framework.common.pojo.CommonResult.success;

/**
 * 管理后台 - 邮箱账号
 */
@RestController
@RequestMapping("/system/mail-account")
public class MailAccountController {

    @Resource
    private MailAccountService mailAccountService;

    /**
     * 创建邮箱账号
     * @param createReqVO
     * @return
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:mail-account:create')")
    public CommonResult<Long> createMailAccount(@Valid @RequestBody MailAccountCreateReqVO createReqVO) {
        return success(mailAccountService.createMailAccount(createReqVO));
    }

    /**
     * 修改邮箱账号
     * @param updateReqVO
     * @return
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:mail-account:update')")
    public CommonResult<Boolean> updateMailAccount(@Valid @RequestBody MailAccountUpdateReqVO updateReqVO) {
        mailAccountService.updateMailAccount(updateReqVO);
        return success(true);
    }

    /**
     * 删除邮箱账号
     * @param id description = "编号", required = true
     * @return
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:mail-account:delete')")
    public CommonResult<Boolean> deleteMailAccount(@RequestParam Long id) {
        mailAccountService.deleteMailAccount(id);
        return success(true);
    }

    /**
     * 获得邮箱账号
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:mail-account:get')")
    public CommonResult<MailAccountRespVO> getMailAccount(@RequestParam("id") Long id) {
        MailAccountDO mailAccountDO = mailAccountService.getMailAccount(id);
        return success(MailAccountConvert.INSTANCE.convert(mailAccountDO));
    }

    /**
     * 获得邮箱账号分页
     * @param pageReqVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:mail-account:query')")
    public CommonResult<PageResult<MailAccountBaseVO>> getMailAccountPage(@Valid MailAccountPageReqVO pageReqVO) {
        PageResult<MailAccountDO> pageResult = mailAccountService.getMailAccountPage(pageReqVO);
        return success(MailAccountConvert.INSTANCE.convertPage(pageResult));
    }

    /**
     * 获得邮箱账号精简列表
     * @return
     */
    @GetMapping("/list-all-simple")
    public CommonResult<List<MailAccountSimpleRespVO>> getSimpleMailAccountList() {
        List<MailAccountDO> list = mailAccountService.getMailAccountList();
        return success(MailAccountConvert.INSTANCE.convertList02(list));
    }

}
