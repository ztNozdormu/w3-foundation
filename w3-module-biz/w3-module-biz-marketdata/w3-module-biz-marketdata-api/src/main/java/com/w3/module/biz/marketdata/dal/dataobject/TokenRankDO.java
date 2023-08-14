package com.w3.module.biz.marketdata.dal.dataobject;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.w3.framework.mybatis.core.dataobject.BaseDO;
import lombok.*;

/**
 * TOKEN排名信息 DO
 *
 * @author 芋道源码
 */
@TableName("mk_token_rank")
@KeySequence("mk_token_rank_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenRankDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Integer id;
    /**
     * 币种基础名称
     */
    private String tokenBaseName;
    /**
     * 是否有最新事件触发(0:没有 1：有)
     */
    private Byte event;
    /**
     * 是否有近期热点消息(0:没有 1：有)
     */
    private Byte hot;
    /**
     * 市值排名
     */
    private Integer capRanking;
    /**
     * 近期交易量
     */
    private Object volRanking;
    /**
     * 板块概念
     */
    private String concept;
    /**
     * 根据币种成交量 热度等生成的排名值 排名值越高币种策略价值越高
     */
    private Byte comprehensiveRanking;

}
