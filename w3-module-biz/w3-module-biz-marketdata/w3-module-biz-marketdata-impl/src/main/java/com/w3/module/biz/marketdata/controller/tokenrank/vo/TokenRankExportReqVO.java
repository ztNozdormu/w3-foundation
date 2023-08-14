package com.w3.module.biz.marketdata.controller.tokenrank.vo;

import lombok.*;
import java.util.*;
import com.w3.framework.common.pojo.PageParam;

/**
* description = "管理后台 - TOKEN排名信息 Excel 导出 Request VO，参数和 TokenRankPageReqVO 是一致的"
*/
@Data
public class TokenRankExportReqVO {

    /**
    * description = "币种基础名称", example = "芋艿"
    */
    private String tokenBaseName;

    /**
    * description = "是否有最新事件触发(0:没有 1：有)"
    */
    private Byte event;

    /**
    * description = "是否有近期热点消息(0:没有 1：有)"
    */
    private Byte hot;

    /**
    * description = "市值排名"
    */
    private Integer capRanking;

    /**
    * description = "近期交易量"
    */
    private Object volRanking;

    /**
    * description = "板块概念"
    */
    private String concept;

    /**
    * description = "根据币种成交量 热度等生成的排名值 排名值越高币种策略价值越高"
    */
    private Byte comprehensiveRanking;

}
