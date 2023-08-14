package com.w3.module.biz.marketdata.convert.tokenrank;

import java.util.*;

import com.w3.framework.common.pojo.PageResult;

import com.w3.module.biz.marketdata.controller.tokenrank.vo.TokenRankCreateReqVO;
import com.w3.module.biz.marketdata.controller.tokenrank.vo.TokenRankExcelVO;
import com.w3.module.biz.marketdata.controller.tokenrank.vo.TokenRankRespVO;
import com.w3.module.biz.marketdata.controller.tokenrank.vo.TokenRankUpdateReqVO;
import com.w3.module.biz.marketdata.dal.dataobject.TokenRankDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TOKEN排名信息 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface TokenRankConvert {

    TokenRankConvert INSTANCE = Mappers.getMapper(TokenRankConvert.class);

    TokenRankDO convert(TokenRankCreateReqVO bean);

    TokenRankDO convert(TokenRankUpdateReqVO bean);

    TokenRankRespVO convert(TokenRankDO bean);

    List<TokenRankRespVO> convertList(List<TokenRankDO> list);

    PageResult<TokenRankRespVO> convertPage(PageResult<TokenRankDO> page);

    List<TokenRankExcelVO> convertList02(List<TokenRankDO> list);

}
