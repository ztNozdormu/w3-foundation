package com.w3.module.biz.marketdata.controller.tokenrank.vo;

import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

/**
 * TOKEN排名信息 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class TokenRankBaseVO {


    /**
    * description = "币种基础名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿"
    */
    @NotNull(message = "币种基础名称不能为空")
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
