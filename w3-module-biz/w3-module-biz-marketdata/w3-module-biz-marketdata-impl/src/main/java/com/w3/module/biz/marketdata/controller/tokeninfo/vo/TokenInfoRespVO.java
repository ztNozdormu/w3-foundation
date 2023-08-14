package com.w3.module.biz.marketdata.controller.tokeninfo.vo;


import lombok.*;

/**
* description = "管理后台 - TOKEN基本信息 Response VO"
*/
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TokenInfoRespVO extends TokenInfoBaseVO {

    /**
    * description = "主键ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "14314"
    */
    private Long id;

}
