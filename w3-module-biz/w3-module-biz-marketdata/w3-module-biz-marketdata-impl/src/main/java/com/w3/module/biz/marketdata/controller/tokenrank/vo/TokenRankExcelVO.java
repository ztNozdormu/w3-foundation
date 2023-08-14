package com.w3.module.biz.marketdata.controller.tokenrank.vo;

import lombok.*;
import java.util.*;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * TOKEN排名信息 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class TokenRankExcelVO {

    @ExcelProperty("主键ID")
    private Integer id;

    @ExcelProperty("币种基础名称")
    private String tokenBaseName;

    @ExcelProperty("是否有最新事件触发(0:没有 1：有)")
    private Byte event;

    @ExcelProperty("是否有近期热点消息(0:没有 1：有)")
    private Byte hot;

    @ExcelProperty("市值排名")
    private Integer capRanking;

    @ExcelProperty("近期交易量")
    private Object volRanking;

    @ExcelProperty("板块概念")
    private String concept;

    @ExcelProperty("根据币种成交量 热度等生成的排名值 排名值越高币种策略价值越高")
    private Byte comprehensiveRanking;

}
