package com.w3.module.biz.marketdata.controller.tokenrank.vo;


import lombok.*;

/**
* description = "管理后台 - TOKEN排名信息 Response VO"
*/
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TokenRankRespVO extends TokenRankBaseVO {

    /**
    * description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "10362"
    */
    private Integer id;

}
