package com.w3.module.biz.marketdata.controller.tokeninfo.vo;

import lombok.*;
import java.util.*;
import com.w3.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static com.w3.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* description = "管理后台 - TOKEN基本信息分页 Request VO"
*/
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TokenInfoPageReqVO extends PageParam {

    /**
    * description = "交易货币币种"
    */
    private String baseCcy;

    /**
    * description = "合约乘数，仅适用于交割/永续/期权"
    */
    private String ctMult;

    /**
    * description = "上线日期"
    */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] listDate;

    /**
    * description = "合约面值，仅适用于交割/永续/期权"
    */
    private String ctVal;

    /**
    * description = "合约面值计价币种，仅适用于交割/永续/期权"
    */
    private String ctValCcy;

    /**
    * description = "交割/行权日期，仅适用于交割 和 期权"
    */
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] expDate;

    /**
    * description = "交易品种，如 BTC-USD，仅适用于交割/永续/期权"
    */
    private String instFamily;

    /**
    * description = "产品id， 如 BTC-USD-SWAP", example = "26637"
    */
    private String instId;

    /**
    * description = " 产品类型	      币币 SPOT	      币币杠杆 MARGIN	      永续合约 SWAP	      交割合约 FUTURES	      期权 OPTION	", example = "2"
    */
    private String instType;

    /**
    * description = "该instId支持的最大杠杆倍数，不适用于币币、期权"
    */
    private String lever;

    /**
    * description = "下单数量精度，如 BTC-USDT-SWAP：1"
    */
    private String lotSz;

    /**
    * description = "合约或现货冰山委托的单笔最大委托数量"
    */
    private String maxIcebergSz;

    /**
    * description = "最大限制数量"
    */
    private String maxLmtSz;

    /**
    * description = "合约或现货市价单的单笔最大委托数量"
    */
    private String maxMktSz;

    /**
    * description = "合约或现货止盈止损委托的单笔最大委托数量"
    */
    private String maxStopSz;

    /**
    * description = "合约或现货计划委托委托的单笔最大委托数量"
    */
    private String maxTriggerSz;

    /**
    * description = "合约或现货时间加权单的单笔最大委托数量"
    */
    private String maxTwapSz;

    /**
    * description = "最小下单数量"
    */
    private String minSz;

    /**
    * description = "期权类型，C或P 仅适用于期权", example = "2"
    */
    private String optType;

    /**
    * description = "计价货币币种，如 BTC-USDT 中的USDT ，仅适用于币币/币币杠杆"
    */
    private String quoteCcy;

    /**
    * description = "盈亏结算和保证金币种，如 BTC 仅适用于交割/永续/期权"
    */
    private String settleCcy;

    /**
    * description = " * 产品状态	     * live：交易中	     * suspend：暂停中	     * preopen：预上线	     * test：测试中（测试产品，不可交易）	     * 当合约预上线时，状态变更为预上线（即新生成一个合约，新合约会处于预上线状态）；	     * 当产品下线的时候（如交割合约被交割的时候，期权合约被行权的时候），查询不到该产品"
    */
    private String state;

    /**
    * description = "行权价格，仅适用于期权"
    */
    private String stk;

    /**
    * description = "下单价格精度，如 0.0001"
    */
    private String tickSz;

    /**
    * description = "标的指数，如 BTC-USD，仅适用于交割/永续/期权"
    */
    private String uly;

    /**
    * description = "交易所类型	      1 币安交易所	      2 欧易交易所	      3 芝麻开门交易所", example = "1"
    */
    private Byte exchangeType;

}
