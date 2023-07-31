package com.knd.module.system.single.controller.admin.notice;


import com.knd.framework.common.pojo.CommonResult;
import com.knd.framework.common.pojo.PageResult;
import com.knd.module.system.convert.notice.NoticeConvert;
import com.knd.module.system.service.notice.NoticeService;
import com.knd.module.system.single.controller.admin.notice.vo.NoticeCreateReqVO;
import com.knd.module.system.single.controller.admin.notice.vo.NoticePageReqVO;
import com.knd.module.system.single.controller.admin.notice.vo.NoticeRespVO;
import com.knd.module.system.single.controller.admin.notice.vo.NoticeUpdateReqVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.knd.framework.common.pojo.CommonResult.success;


/**
 * 管理后台 - 通知公告
 */
@RestController
@RequestMapping("/system/notice")
@Validated
public class NoticeController {

    @Resource
    private NoticeService noticeService;

    /**
     * 创建通知公告
     * @param reqVO
     * @return
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:notice:create')")
    public CommonResult<Long> createNotice(@Valid @RequestBody NoticeCreateReqVO reqVO) {
        Long noticeId = noticeService.createNotice(reqVO);
        return success(noticeId);
    }

    /**
     * 修改通知公告
     * @param reqVO
     * @return
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:notice:update')")
    public CommonResult<Boolean> updateNotice(@Valid @RequestBody NoticeUpdateReqVO reqVO) {
        noticeService.updateNotice(reqVO);
        return success(true);
    }

    /**
     * 删除通知公告
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:notice:delete')")
    public CommonResult<Boolean> deleteNotice(@RequestParam("id") Long id) {
        noticeService.deleteNotice(id);
        return success(true);
    }

    /**
     * 获取通知公告列表
     * @param reqVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:notice:query')")
    public CommonResult<PageResult<NoticeRespVO>> getNoticePage(@Validated NoticePageReqVO reqVO) {
        return success(NoticeConvert.INSTANCE.convertPage(noticeService.getNoticePage(reqVO)));
    }

    /**
     * 获得通知公告
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:notice:query')")
    public CommonResult<NoticeRespVO> getNotice(@RequestParam("id") Long id) {
        return success(NoticeConvert.INSTANCE.convert(noticeService.getNotice(id)));
    }

}
