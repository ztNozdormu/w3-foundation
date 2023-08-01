package com.w3.module.system.controller.admin.tenant.vo.tenant;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
* 租户 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class TenantBaseVO {

    /**
     * description = "租户名", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋道"
     */
    @NotNull(message = "租户名不能为空")
    private String name;

    /**
     * description = "联系人", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿"
     */
    @NotNull(message = "联系人不能为空")
    private String contactName;

    /**
     * description = "联系手机", example = "15601691300"
     */
    private String contactMobile;

    /**
     * description = "租户状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
     */
    @NotNull(message = "租户状态")
    private Integer status;

    /**
     * description = "绑定域名", example = "https://www.iocoder.cn"
     */
    private String domain;

    /**
     * description = "租户套餐编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    @NotNull(message = "租户套餐编号不能为空")
    private Long packageId;

    /**
     * description = "过期时间", requiredMode = Schema.RequiredMode.REQUIRED
     */
    @NotNull(message = "过期时间不能为空")
    private LocalDateTime expireTime;

    /**
     * description = "账号数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    @NotNull(message = "账号数量不能为空")
    private Integer accountCount;

}
