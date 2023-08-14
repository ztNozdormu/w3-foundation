package com.w3.module.biz.marketdata.controller.tokenrank.vo;

import lombok.*;

import javax.validation.constraints.*;

/**
* description = "管理后台 - TOKEN排名信息更新 Request VO"
*/
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TokenRankUpdateReqVO extends TokenRankBaseVO {


    /**
    * description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "10362"
    */
    @NotNull(message = "主键ID不能为空")
    private Integer id;

}
