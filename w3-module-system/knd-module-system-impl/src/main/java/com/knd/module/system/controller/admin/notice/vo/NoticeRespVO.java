package com.knd.module.system.controller.admin.notice.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * description = "管理后台 - 通知公告信息 Response VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NoticeRespVO extends NoticeBaseVO {

    /**
     * description = "通知公告序号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    private Long id;

    /**
     * description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "时间戳格式"
     */
    private LocalDateTime createTime;

}
