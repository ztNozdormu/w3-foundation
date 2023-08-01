package com.w3.module.system.controller.admin.sms;


import com.w3.framework.common.pojo.CommonResult;
import com.w3.framework.common.pojo.PageResult;
import com.w3.module.system.controller.admin.sms.vo.channel.*;
import com.w3.module.system.convert.sms.SmsChannelConvert;
import com.w3.module.system.dal.dataobject.sms.SmsChannelDO;
import com.w3.module.system.service.sms.SmsChannelService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;

import static com.w3.framework.common.pojo.CommonResult.success;


/**
 * 管理后台 - 短信渠道
 */
@RestController
@RequestMapping("system/sms-channel")
public class SmsChannelController {

    @Resource
    private SmsChannelService smsChannelService;

    /**
     * 创建短信渠道
     * @param createReqVO
     * @return
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:sms-channel:create')")
    public CommonResult<Long> createSmsChannel(@Valid @RequestBody SmsChannelCreateReqVO createReqVO) {
        return success(smsChannelService.createSmsChannel(createReqVO));
    }

    /**
     * 更新短信渠道
     * @param updateReqVO
     * @return
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:sms-channel:update')")
    public CommonResult<Boolean> updateSmsChannel(@Valid @RequestBody SmsChannelUpdateReqVO updateReqVO) {
        smsChannelService.updateSmsChannel(updateReqVO);
        return success(true);
    }

    /**
     * 删除短信渠道
     * @param id  description = "编号", required = true
     * @return
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:sms-channel:delete')")
    public CommonResult<Boolean> deleteSmsChannel(@RequestParam("id") Long id) {
        smsChannelService.deleteSmsChannel(id);
        return success(true);
    }

    /**
     * 获得短信渠道
     * @param id  description = "编号", required = true, example = "1024"
     * @return
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:sms-channel:query')")
    public CommonResult<SmsChannelRespVO> getSmsChannel(@RequestParam("id") Long id) {
        SmsChannelDO smsChannel = smsChannelService.getSmsChannel(id);
        return success(SmsChannelConvert.INSTANCE.convert(smsChannel));
    }

    /**
     * 获得短信渠道分页
     * @param pageVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:sms-channel:query')")
    public CommonResult<PageResult<SmsChannelRespVO>> getSmsChannelPage(@Valid SmsChannelPageReqVO pageVO) {
        PageResult<SmsChannelDO> pageResult = smsChannelService.getSmsChannelPage(pageVO);
        return success(SmsChannelConvert.INSTANCE.convertPage(pageResult));
    }

    /**
     * 获得短信渠道精简列表  description = "包含被禁用的短信渠道"
     * @return
     */
    @GetMapping("/list-all-simple")
    public CommonResult<List<SmsChannelSimpleRespVO>> getSimpleSmsChannelList() {
        List<SmsChannelDO> list = smsChannelService.getSmsChannelList();
        // 排序后，返回给前端
        list.sort(Comparator.comparing(SmsChannelDO::getId));
        return success(SmsChannelConvert.INSTANCE.convertList03(list));
    }

}
