package com.w3.module.system.controller.admin.permission.vo.role;

import com.w3.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static com.w3.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * 管理后台 - 角色分页 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RolePageReqVO extends PageParam {

    /**
     * 角色名称,模糊匹配  example = "芋道"
     */
    private String name;

    /**
     *  角色标识,模糊匹配 example = "yudao"
     */
    private String code;

    /**
     *展示状态,参见 CommonStatusEnum 枚举类 example = "1"
     */
    private Integer status;

    /**
     * 创建时间 example = "[2022-07-01 00:00:00,2022-07-01 23:59:59]"
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
