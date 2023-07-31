package com.knd.module.system.controller.admin.notice.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * description = "管理后台 - 岗位公告更新 Request VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NoticeUpdateReqVO extends NoticeBaseVO {

    /**
     * description = "岗位公告编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    @NotNull(message = "岗位公告编号不能为空")
    private Long id;

}
