package com.w3.module.biz.marketdata.convert.tokenrank;

import com.w3.framework.common.pojo.PageResult;
import com.w3.module.biz.marketdata.controller.tokenrank.vo.TokenRankCreateReqVO;
import com.w3.module.biz.marketdata.controller.tokenrank.vo.TokenRankExcelVO;
import com.w3.module.biz.marketdata.controller.tokenrank.vo.TokenRankRespVO;
import com.w3.module.biz.marketdata.controller.tokenrank.vo.TokenRankUpdateReqVO;
import com.w3.module.biz.marketdata.dal.dataobject.TokenRankDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-18T17:26:45+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class TokenRankConvertImpl implements TokenRankConvert {

    @Override
    public TokenRankDO convert(TokenRankCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        TokenRankDO.TokenRankDOBuilder tokenRankDO = TokenRankDO.builder();

        tokenRankDO.tokenBaseName( bean.getTokenBaseName() );
        tokenRankDO.event( bean.getEvent() );
        tokenRankDO.hot( bean.getHot() );
        tokenRankDO.capRanking( bean.getCapRanking() );
        tokenRankDO.volRanking( bean.getVolRanking() );
        tokenRankDO.concept( bean.getConcept() );
        tokenRankDO.comprehensiveRanking( bean.getComprehensiveRanking() );

        return tokenRankDO.build();
    }

    @Override
    public TokenRankDO convert(TokenRankUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        TokenRankDO.TokenRankDOBuilder tokenRankDO = TokenRankDO.builder();

        tokenRankDO.id( bean.getId() );
        tokenRankDO.tokenBaseName( bean.getTokenBaseName() );
        tokenRankDO.event( bean.getEvent() );
        tokenRankDO.hot( bean.getHot() );
        tokenRankDO.capRanking( bean.getCapRanking() );
        tokenRankDO.volRanking( bean.getVolRanking() );
        tokenRankDO.concept( bean.getConcept() );
        tokenRankDO.comprehensiveRanking( bean.getComprehensiveRanking() );

        return tokenRankDO.build();
    }

    @Override
    public TokenRankRespVO convert(TokenRankDO bean) {
        if ( bean == null ) {
            return null;
        }

        TokenRankRespVO tokenRankRespVO = new TokenRankRespVO();

        tokenRankRespVO.setTokenBaseName( bean.getTokenBaseName() );
        tokenRankRespVO.setEvent( bean.getEvent() );
        tokenRankRespVO.setHot( bean.getHot() );
        tokenRankRespVO.setCapRanking( bean.getCapRanking() );
        tokenRankRespVO.setVolRanking( bean.getVolRanking() );
        tokenRankRespVO.setConcept( bean.getConcept() );
        tokenRankRespVO.setComprehensiveRanking( bean.getComprehensiveRanking() );
        tokenRankRespVO.setId( bean.getId() );

        return tokenRankRespVO;
    }

    @Override
    public List<TokenRankRespVO> convertList(List<TokenRankDO> list) {
        if ( list == null ) {
            return null;
        }

        List<TokenRankRespVO> list1 = new ArrayList<TokenRankRespVO>( list.size() );
        for ( TokenRankDO tokenRankDO : list ) {
            list1.add( convert( tokenRankDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<TokenRankRespVO> convertPage(PageResult<TokenRankDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<TokenRankRespVO> pageResult = new PageResult<TokenRankRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public List<TokenRankExcelVO> convertList02(List<TokenRankDO> list) {
        if ( list == null ) {
            return null;
        }

        List<TokenRankExcelVO> list1 = new ArrayList<TokenRankExcelVO>( list.size() );
        for ( TokenRankDO tokenRankDO : list ) {
            list1.add( tokenRankDOToTokenRankExcelVO( tokenRankDO ) );
        }

        return list1;
    }

    protected TokenRankExcelVO tokenRankDOToTokenRankExcelVO(TokenRankDO tokenRankDO) {
        if ( tokenRankDO == null ) {
            return null;
        }

        TokenRankExcelVO tokenRankExcelVO = new TokenRankExcelVO();

        tokenRankExcelVO.setId( tokenRankDO.getId() );
        tokenRankExcelVO.setTokenBaseName( tokenRankDO.getTokenBaseName() );
        tokenRankExcelVO.setEvent( tokenRankDO.getEvent() );
        tokenRankExcelVO.setHot( tokenRankDO.getHot() );
        tokenRankExcelVO.setCapRanking( tokenRankDO.getCapRanking() );
        tokenRankExcelVO.setVolRanking( tokenRankDO.getVolRanking() );
        tokenRankExcelVO.setConcept( tokenRankDO.getConcept() );
        tokenRankExcelVO.setComprehensiveRanking( tokenRankDO.getComprehensiveRanking() );

        return tokenRankExcelVO;
    }
}
