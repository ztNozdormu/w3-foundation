package com.knd.module.system.controller.admin.dept.vo.post;

import com.knd.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * description = "管理后台 - 岗位分页 Request VO"
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PostPageReqVO extends PageParam {

    /**
     * description = "岗位编码,模糊匹配", example = "yudao"
     */
    private String code;

    /**
     * description = "岗位名称,模糊匹配", example = "芋道"
     */
    private String name;

    /**
     * description = "展示状态,参见 CommonStatusEnum 枚举类", example = "1"
     */
    private Integer status;

}
