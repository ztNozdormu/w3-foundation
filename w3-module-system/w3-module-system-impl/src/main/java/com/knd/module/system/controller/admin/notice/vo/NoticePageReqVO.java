package com.w3.module.system.controller.admin.notice.vo;

import com.w3.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description = "管理后台 - 通知公告分页 Request VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NoticePageReqVO extends PageParam {

    /**
     * description = "通知公告名称,模糊匹配", example = "芋道"
     */
    private String title;

    /**
     * description ="展示状态,参见 CommonStatusEnum 枚举类",example ="1"
     */
    private Integer status;

}
