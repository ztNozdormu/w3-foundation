package com.w3.module.biz.marketdata.controller.tokeninfo.vo;

import lombok.*;

import javax.validation.constraints.*;

/**
* description = "管理后台 - TOKEN基本信息更新 Request VO"
*/
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TokenInfoUpdateReqVO extends TokenInfoBaseVO {


    /**
    * description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "14314"
    */
    @NotNull(message = "主键ID不能为空")
    private Long id;

}
