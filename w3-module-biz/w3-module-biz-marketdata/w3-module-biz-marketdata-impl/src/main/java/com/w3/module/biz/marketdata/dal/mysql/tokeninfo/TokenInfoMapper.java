package com.w3.module.biz.marketdata.dal.mysql.tokeninfo;

import java.util.*;

import com.w3.framework.common.pojo.PageResult;
import com.w3.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.w3.framework.mybatis.core.mapper.BaseMapperX;
import com.w3.module.biz.marketdata.controller.tokeninfo.vo.TokenInfoExportReqVO;
import com.w3.module.biz.marketdata.controller.tokeninfo.vo.TokenInfoPageReqVO;
import com.w3.module.biz.marketdata.dal.dataobject.TokenInfoDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * TOKEN基本信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface TokenInfoMapper extends BaseMapperX<TokenInfoDO> {

    default PageResult<TokenInfoDO> selectPage(TokenInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TokenInfoDO>()
                .eqIfPresent(TokenInfoDO::getBaseCcy, reqVO.getBaseCcy())
                .eqIfPresent(TokenInfoDO::getCtMult, reqVO.getCtMult())
                .betweenIfPresent(TokenInfoDO::getListDate, reqVO.getListDate())
                .eqIfPresent(TokenInfoDO::getCtVal, reqVO.getCtVal())
                .eqIfPresent(TokenInfoDO::getCtValCcy, reqVO.getCtValCcy())
                .betweenIfPresent(TokenInfoDO::getExpDate, reqVO.getExpDate())
                .eqIfPresent(TokenInfoDO::getInstFamily, reqVO.getInstFamily())
                .eqIfPresent(TokenInfoDO::getInstId, reqVO.getInstId())
                .eqIfPresent(TokenInfoDO::getInstType, reqVO.getInstType())
                .eqIfPresent(TokenInfoDO::getLever, reqVO.getLever())
                .eqIfPresent(TokenInfoDO::getLotSz, reqVO.getLotSz())
                .eqIfPresent(TokenInfoDO::getMaxIcebergSz, reqVO.getMaxIcebergSz())
                .eqIfPresent(TokenInfoDO::getMaxLmtSz, reqVO.getMaxLmtSz())
                .eqIfPresent(TokenInfoDO::getMaxMktSz, reqVO.getMaxMktSz())
                .eqIfPresent(TokenInfoDO::getMaxStopSz, reqVO.getMaxStopSz())
                .eqIfPresent(TokenInfoDO::getMaxTriggerSz, reqVO.getMaxTriggerSz())
                .eqIfPresent(TokenInfoDO::getMaxTwapSz, reqVO.getMaxTwapSz())
                .eqIfPresent(TokenInfoDO::getMinSz, reqVO.getMinSz())
                .eqIfPresent(TokenInfoDO::getOptType, reqVO.getOptType())
                .eqIfPresent(TokenInfoDO::getQuoteCcy, reqVO.getQuoteCcy())
                .eqIfPresent(TokenInfoDO::getSettleCcy, reqVO.getSettleCcy())
                .eqIfPresent(TokenInfoDO::getState, reqVO.getState())
                .eqIfPresent(TokenInfoDO::getStk, reqVO.getStk())
                .eqIfPresent(TokenInfoDO::getTickSz, reqVO.getTickSz())
                .eqIfPresent(TokenInfoDO::getUly, reqVO.getUly())
                .eqIfPresent(TokenInfoDO::getExchangeType, reqVO.getExchangeType())
                .orderByDesc(TokenInfoDO::getId));
    }

    default List<TokenInfoDO> selectList(TokenInfoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<TokenInfoDO>()
                .eqIfPresent(TokenInfoDO::getBaseCcy, reqVO.getBaseCcy())
                .eqIfPresent(TokenInfoDO::getCtMult, reqVO.getCtMult())
                .betweenIfPresent(TokenInfoDO::getListDate, reqVO.getListDate())
                .eqIfPresent(TokenInfoDO::getCtVal, reqVO.getCtVal())
                .eqIfPresent(TokenInfoDO::getCtValCcy, reqVO.getCtValCcy())
                .betweenIfPresent(TokenInfoDO::getExpDate, reqVO.getExpDate())
                .eqIfPresent(TokenInfoDO::getInstFamily, reqVO.getInstFamily())
                .eqIfPresent(TokenInfoDO::getInstId, reqVO.getInstId())
                .eqIfPresent(TokenInfoDO::getInstType, reqVO.getInstType())
                .eqIfPresent(TokenInfoDO::getLever, reqVO.getLever())
                .eqIfPresent(TokenInfoDO::getLotSz, reqVO.getLotSz())
                .eqIfPresent(TokenInfoDO::getMaxIcebergSz, reqVO.getMaxIcebergSz())
                .eqIfPresent(TokenInfoDO::getMaxLmtSz, reqVO.getMaxLmtSz())
                .eqIfPresent(TokenInfoDO::getMaxMktSz, reqVO.getMaxMktSz())
                .eqIfPresent(TokenInfoDO::getMaxStopSz, reqVO.getMaxStopSz())
                .eqIfPresent(TokenInfoDO::getMaxTriggerSz, reqVO.getMaxTriggerSz())
                .eqIfPresent(TokenInfoDO::getMaxTwapSz, reqVO.getMaxTwapSz())
                .eqIfPresent(TokenInfoDO::getMinSz, reqVO.getMinSz())
                .eqIfPresent(TokenInfoDO::getOptType, reqVO.getOptType())
                .eqIfPresent(TokenInfoDO::getQuoteCcy, reqVO.getQuoteCcy())
                .eqIfPresent(TokenInfoDO::getSettleCcy, reqVO.getSettleCcy())
                .eqIfPresent(TokenInfoDO::getState, reqVO.getState())
                .eqIfPresent(TokenInfoDO::getStk, reqVO.getStk())
                .eqIfPresent(TokenInfoDO::getTickSz, reqVO.getTickSz())
                .eqIfPresent(TokenInfoDO::getUly, reqVO.getUly())
                .eqIfPresent(TokenInfoDO::getExchangeType, reqVO.getExchangeType())
                .orderByDesc(TokenInfoDO::getId));
    }

}
