package com.w3.module.biz.marketdata.dal.mysql.tokenrank;

import java.util.*;

import com.w3.framework.common.pojo.PageResult;
import com.w3.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.w3.framework.mybatis.core.mapper.BaseMapperX;
import com.w3.module.biz.marketdata.controller.tokenrank.vo.TokenRankExportReqVO;
import com.w3.module.biz.marketdata.controller.tokenrank.vo.TokenRankPageReqVO;
import com.w3.module.biz.marketdata.dal.dataobject.TokenRankDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * TOKEN排名信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface TokenRankMapper extends BaseMapperX<TokenRankDO> {

    default PageResult<TokenRankDO> selectPage(TokenRankPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TokenRankDO>()
                .likeIfPresent(TokenRankDO::getTokenBaseName, reqVO.getTokenBaseName())
                .eqIfPresent(TokenRankDO::getEvent, reqVO.getEvent())
                .eqIfPresent(TokenRankDO::getHot, reqVO.getHot())
                .eqIfPresent(TokenRankDO::getCapRanking, reqVO.getCapRanking())
                .eqIfPresent(TokenRankDO::getVolRanking, reqVO.getVolRanking())
                .eqIfPresent(TokenRankDO::getConcept, reqVO.getConcept())
                .eqIfPresent(TokenRankDO::getComprehensiveRanking, reqVO.getComprehensiveRanking())
                .orderByDesc(TokenRankDO::getId));
    }

    default List<TokenRankDO> selectList(TokenRankExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<TokenRankDO>()
                .likeIfPresent(TokenRankDO::getTokenBaseName, reqVO.getTokenBaseName())
                .eqIfPresent(TokenRankDO::getEvent, reqVO.getEvent())
                .eqIfPresent(TokenRankDO::getHot, reqVO.getHot())
                .eqIfPresent(TokenRankDO::getCapRanking, reqVO.getCapRanking())
                .eqIfPresent(TokenRankDO::getVolRanking, reqVO.getVolRanking())
                .eqIfPresent(TokenRankDO::getConcept, reqVO.getConcept())
                .eqIfPresent(TokenRankDO::getComprehensiveRanking, reqVO.getComprehensiveRanking())
                .orderByDesc(TokenRankDO::getId));
    }

}
