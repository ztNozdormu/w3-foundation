package com.w3.module.system.controller.admin.notify;


import com.w3.framework.common.enums.UserTypeEnum;
import com.w3.framework.common.pojo.CommonResult;
import com.w3.framework.common.pojo.PageResult;
import com.w3.module.system.controller.admin.notify.vo.message.NotifyMessageMyPageReqVO;
import com.w3.module.system.controller.admin.notify.vo.message.NotifyMessagePageReqVO;
import com.w3.module.system.controller.admin.notify.vo.message.NotifyMessageRespVO;
import com.w3.module.system.convert.notify.NotifyMessageConvert;
import com.w3.module.system.dal.dataobject.notify.NotifyMessageDO;
import com.w3.module.system.service.notify.NotifyMessageService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static com.w3.framework.common.pojo.CommonResult.success;
import static com.w3.framework.web.core.util.WebFrameworkUtils.getLoginUserId;


/**
 * 管理后台 - 我的站内信
 */
@RestController
@RequestMapping("/system/notify-message")
@Validated
public class NotifyMessageController {

    @Resource
    private NotifyMessageService notifyMessageService;

    // ========== 管理所有的站内信 ==========

    /**
     * 获得站内信
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:notify-message:query')")
    public CommonResult<NotifyMessageRespVO> getNotifyMessage(@RequestParam("id") Long id) {
        NotifyMessageDO notifyMessage = notifyMessageService.getNotifyMessage(id);
        return success(NotifyMessageConvert.INSTANCE.convert(notifyMessage));
    }

    /**
     * 获得站内信分页
     * @param pageVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:notify-message:query')")
    public CommonResult<PageResult<NotifyMessageRespVO>> getNotifyMessagePage(@Valid NotifyMessagePageReqVO pageVO) {
        PageResult<NotifyMessageDO> pageResult = notifyMessageService.getNotifyMessagePage(pageVO);
        return success(NotifyMessageConvert.INSTANCE.convertPage(pageResult));
    }

    // ========== 查看自己的站内信 ==========

    /**
     * 获得我的站内信分页
     * @param pageVO
     * @return
     */
    @GetMapping("/my-page")
    public CommonResult<PageResult<NotifyMessageRespVO>> getMyMyNotifyMessagePage(@Valid NotifyMessageMyPageReqVO pageVO) {
        PageResult<NotifyMessageDO> pageResult = notifyMessageService.getMyMyNotifyMessagePage(pageVO,
                getLoginUserId(), UserTypeEnum.ADMIN.getValue());
        return success(NotifyMessageConvert.INSTANCE.convertPage(pageResult));
    }

    /**
     * 标记站内信为已读
     * @param ids description = "编号列表", required = true, example = "1024,2048"
     * @return
     */
    @PutMapping("/update-read")
    public CommonResult<Boolean> updateNotifyMessageRead(@RequestParam("ids") List<Long> ids) {
        notifyMessageService.updateNotifyMessageRead(ids, getLoginUserId(), UserTypeEnum.ADMIN.getValue());
        return success(Boolean.TRUE);
    }

    /**
     * 标记所有站内信为已读
     * @return
     */
    @PutMapping("/update-all-read")
    public CommonResult<Boolean> updateAllNotifyMessageRead() {
        notifyMessageService.updateAllNotifyMessageRead(getLoginUserId(), UserTypeEnum.ADMIN.getValue());
        return success(Boolean.TRUE);
    }

    /**
     * 获取当前用户的最新站内信列表，默认 10 条
     * @param size description = "10"
     * @return
     */
    @GetMapping("/get-unread-list")
    public CommonResult<List<NotifyMessageRespVO>> getUnreadNotifyMessageList(
            @RequestParam(name = "size", defaultValue = "10") Integer size) {
        List<NotifyMessageDO> list = notifyMessageService.getUnreadNotifyMessageList(
                getLoginUserId(), UserTypeEnum.ADMIN.getValue(), size);
        return success(NotifyMessageConvert.INSTANCE.convertList(list));
    }

    /**
     * 获得当前用户的未读站内信数量
     * @return
     */
    @GetMapping("/get-unread-count")
    public CommonResult<Long> getUnreadNotifyMessageCount() {
        return success(notifyMessageService.getUnreadNotifyMessageCount(getLoginUserId(), UserTypeEnum.ADMIN.getValue()));
    }

}
