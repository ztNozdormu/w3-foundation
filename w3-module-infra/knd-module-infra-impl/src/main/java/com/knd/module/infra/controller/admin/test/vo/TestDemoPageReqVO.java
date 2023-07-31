package com.knd.module.infra.controller.admin.test.vo;

import com.knd.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.knd.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;


/**
 * 管理后台 - 字典类型分页 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TestDemoPageReqVO extends PageParam {

    /**
     * 名字
     */
    private String name;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 分类
     */
    private Integer category;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
