package com.w3.module.system.controller.admin.notify.vo.message;

import com.w3.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.w3.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * description = "管理后台 - 站内信分页 Request VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class NotifyMessagePageReqVO extends PageParam {

    /**
     * description = "用户编号", example = "25025"
     */
    private Long userId;

    /**
     * description = "用户类型", example = "1"
     */
    private Integer userType;

    /**
     * description = "模板编码", example = "test_01"
     */
    private String templateCode;

    /**
     * description = "模版类型", example = "2"
     */
    private Integer templateType;

    /**
     * description = "创建时间"
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
