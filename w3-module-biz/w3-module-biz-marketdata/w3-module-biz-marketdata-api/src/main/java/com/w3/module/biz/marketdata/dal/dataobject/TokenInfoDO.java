package com.w3.module.biz.marketdata.dal.dataobject;

import com.w3.framework.mybatis.core.dataobject.BaseDO;
import lombok.*;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;

/**
 * TOKEN基本信息 DO
 *
 * @author 芋道源码
 */
@TableName("mk_token_info")
@KeySequence("mk_token_info_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenInfoDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 交易货币币种
     */
    private String baseCcy;
    /**
     * 合约乘数，仅适用于交割/永续/期权
     */
    private String ctMult;
    /**
     * 上线日期
     */
    private LocalDateTime listDate;
    /**
     * 合约面值，仅适用于交割/永续/期权
     */
    private String ctVal;
    /**
     * 合约面值计价币种，仅适用于交割/永续/期权
     */
    private String ctValCcy;
    /**
     * 交割/行权日期，仅适用于交割 和 期权
     */
    private LocalDateTime expDate;
    /**
     * 交易品种，如 BTC-USD，仅适用于交割/永续/期权
     */
    private String instFamily;
    /**
     * 产品id， 如 BTC-USD-SWAP
     */
    private String instId;
    /**
     *  产品类型	      币币 SPOT	      币币杠杆 MARGIN	      永续合约 SWAP	      交割合约 FUTURES	      期权 OPTION	
     */
    private String instType;
    /**
     * 该instId支持的最大杠杆倍数，不适用于币币、期权
     */
    private String lever;
    /**
     * 下单数量精度，如 BTC-USDT-SWAP：1
     */
    private String lotSz;
    /**
     * 合约或现货冰山委托的单笔最大委托数量
     */
    private String maxIcebergSz;
    /**
     * 最大限制数量
     */
    private String maxLmtSz;
    /**
     * 合约或现货市价单的单笔最大委托数量
     */
    private String maxMktSz;
    /**
     * 合约或现货止盈止损委托的单笔最大委托数量
     */
    private String maxStopSz;
    /**
     * 合约或现货计划委托委托的单笔最大委托数量
     */
    private String maxTriggerSz;
    /**
     * 合约或现货时间加权单的单笔最大委托数量
     */
    private String maxTwapSz;
    /**
     * 最小下单数量
     */
    private String minSz;
    /**
     * 期权类型，C或P 仅适用于期权
     */
    private String optType;
    /**
     * 计价货币币种，如 BTC-USDT 中的USDT ，仅适用于币币/币币杠杆
     */
    private String quoteCcy;
    /**
     * 盈亏结算和保证金币种，如 BTC 仅适用于交割/永续/期权
     */
    private String settleCcy;
    /**
     * * 产品状态	     * live：交易中	     * suspend：暂停中	     * preopen：预上线	     * test：测试中（测试产品，不可交易）	     * 当合约预上线时，状态变更为预上线（即新生成一个合约，新合约会处于预上线状态）；	     * 当产品下线的时候（如交割合约被交割的时候，期权合约被行权的时候），查询不到该产品
     */
    private String state;
    /**
     * 行权价格，仅适用于期权
     */
    private String stk;
    /**
     * 下单价格精度，如 0.0001
     */
    private String tickSz;
    /**
     * 标的指数，如 BTC-USD，仅适用于交割/永续/期权
     */
    private String uly;
    /**
     * 交易所类型	      1 币安交易所	      2 欧易交易所	      3 芝麻开门交易所
     */
    private Byte exchangeType;

}
