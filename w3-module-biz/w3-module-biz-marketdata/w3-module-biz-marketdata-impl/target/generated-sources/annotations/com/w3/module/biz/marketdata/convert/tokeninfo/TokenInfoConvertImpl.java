package com.w3.module.biz.marketdata.convert.tokeninfo;

import com.w3.framework.common.pojo.PageResult;
import com.w3.module.biz.marketdata.controller.tokeninfo.vo.TokenInfoCreateReqVO;
import com.w3.module.biz.marketdata.controller.tokeninfo.vo.TokenInfoExcelVO;
import com.w3.module.biz.marketdata.controller.tokeninfo.vo.TokenInfoRespVO;
import com.w3.module.biz.marketdata.controller.tokeninfo.vo.TokenInfoUpdateReqVO;
import com.w3.module.biz.marketdata.dal.dataobject.TokenInfoDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-14T17:38:15+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class TokenInfoConvertImpl implements TokenInfoConvert {

    @Override
    public TokenInfoDO convert(TokenInfoCreateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        TokenInfoDO.TokenInfoDOBuilder tokenInfoDO = TokenInfoDO.builder();

        tokenInfoDO.baseCcy( bean.getBaseCcy() );
        tokenInfoDO.ctMult( bean.getCtMult() );
        tokenInfoDO.listDate( bean.getListDate() );
        tokenInfoDO.ctVal( bean.getCtVal() );
        tokenInfoDO.ctValCcy( bean.getCtValCcy() );
        tokenInfoDO.expDate( bean.getExpDate() );
        tokenInfoDO.instFamily( bean.getInstFamily() );
        tokenInfoDO.instId( bean.getInstId() );
        tokenInfoDO.instType( bean.getInstType() );
        tokenInfoDO.lever( bean.getLever() );
        tokenInfoDO.lotSz( bean.getLotSz() );
        tokenInfoDO.maxIcebergSz( bean.getMaxIcebergSz() );
        tokenInfoDO.maxLmtSz( bean.getMaxLmtSz() );
        tokenInfoDO.maxMktSz( bean.getMaxMktSz() );
        tokenInfoDO.maxStopSz( bean.getMaxStopSz() );
        tokenInfoDO.maxTriggerSz( bean.getMaxTriggerSz() );
        tokenInfoDO.maxTwapSz( bean.getMaxTwapSz() );
        tokenInfoDO.minSz( bean.getMinSz() );
        tokenInfoDO.optType( bean.getOptType() );
        tokenInfoDO.quoteCcy( bean.getQuoteCcy() );
        tokenInfoDO.settleCcy( bean.getSettleCcy() );
        tokenInfoDO.state( bean.getState() );
        tokenInfoDO.stk( bean.getStk() );
        tokenInfoDO.tickSz( bean.getTickSz() );
        tokenInfoDO.uly( bean.getUly() );
        tokenInfoDO.exchangeType( bean.getExchangeType() );

        return tokenInfoDO.build();
    }

    @Override
    public TokenInfoDO convert(TokenInfoUpdateReqVO bean) {
        if ( bean == null ) {
            return null;
        }

        TokenInfoDO.TokenInfoDOBuilder tokenInfoDO = TokenInfoDO.builder();

        tokenInfoDO.id( bean.getId() );
        tokenInfoDO.baseCcy( bean.getBaseCcy() );
        tokenInfoDO.ctMult( bean.getCtMult() );
        tokenInfoDO.listDate( bean.getListDate() );
        tokenInfoDO.ctVal( bean.getCtVal() );
        tokenInfoDO.ctValCcy( bean.getCtValCcy() );
        tokenInfoDO.expDate( bean.getExpDate() );
        tokenInfoDO.instFamily( bean.getInstFamily() );
        tokenInfoDO.instId( bean.getInstId() );
        tokenInfoDO.instType( bean.getInstType() );
        tokenInfoDO.lever( bean.getLever() );
        tokenInfoDO.lotSz( bean.getLotSz() );
        tokenInfoDO.maxIcebergSz( bean.getMaxIcebergSz() );
        tokenInfoDO.maxLmtSz( bean.getMaxLmtSz() );
        tokenInfoDO.maxMktSz( bean.getMaxMktSz() );
        tokenInfoDO.maxStopSz( bean.getMaxStopSz() );
        tokenInfoDO.maxTriggerSz( bean.getMaxTriggerSz() );
        tokenInfoDO.maxTwapSz( bean.getMaxTwapSz() );
        tokenInfoDO.minSz( bean.getMinSz() );
        tokenInfoDO.optType( bean.getOptType() );
        tokenInfoDO.quoteCcy( bean.getQuoteCcy() );
        tokenInfoDO.settleCcy( bean.getSettleCcy() );
        tokenInfoDO.state( bean.getState() );
        tokenInfoDO.stk( bean.getStk() );
        tokenInfoDO.tickSz( bean.getTickSz() );
        tokenInfoDO.uly( bean.getUly() );
        tokenInfoDO.exchangeType( bean.getExchangeType() );

        return tokenInfoDO.build();
    }

    @Override
    public TokenInfoRespVO convert(TokenInfoDO bean) {
        if ( bean == null ) {
            return null;
        }

        TokenInfoRespVO tokenInfoRespVO = new TokenInfoRespVO();

        tokenInfoRespVO.setBaseCcy( bean.getBaseCcy() );
        tokenInfoRespVO.setCtMult( bean.getCtMult() );
        tokenInfoRespVO.setListDate( bean.getListDate() );
        tokenInfoRespVO.setCtVal( bean.getCtVal() );
        tokenInfoRespVO.setCtValCcy( bean.getCtValCcy() );
        tokenInfoRespVO.setExpDate( bean.getExpDate() );
        tokenInfoRespVO.setInstFamily( bean.getInstFamily() );
        tokenInfoRespVO.setInstId( bean.getInstId() );
        tokenInfoRespVO.setInstType( bean.getInstType() );
        tokenInfoRespVO.setLever( bean.getLever() );
        tokenInfoRespVO.setLotSz( bean.getLotSz() );
        tokenInfoRespVO.setMaxIcebergSz( bean.getMaxIcebergSz() );
        tokenInfoRespVO.setMaxLmtSz( bean.getMaxLmtSz() );
        tokenInfoRespVO.setMaxMktSz( bean.getMaxMktSz() );
        tokenInfoRespVO.setMaxStopSz( bean.getMaxStopSz() );
        tokenInfoRespVO.setMaxTriggerSz( bean.getMaxTriggerSz() );
        tokenInfoRespVO.setMaxTwapSz( bean.getMaxTwapSz() );
        tokenInfoRespVO.setMinSz( bean.getMinSz() );
        tokenInfoRespVO.setOptType( bean.getOptType() );
        tokenInfoRespVO.setQuoteCcy( bean.getQuoteCcy() );
        tokenInfoRespVO.setSettleCcy( bean.getSettleCcy() );
        tokenInfoRespVO.setState( bean.getState() );
        tokenInfoRespVO.setStk( bean.getStk() );
        tokenInfoRespVO.setTickSz( bean.getTickSz() );
        tokenInfoRespVO.setUly( bean.getUly() );
        tokenInfoRespVO.setExchangeType( bean.getExchangeType() );
        tokenInfoRespVO.setId( bean.getId() );

        return tokenInfoRespVO;
    }

    @Override
    public List<TokenInfoRespVO> convertList(List<TokenInfoDO> list) {
        if ( list == null ) {
            return null;
        }

        List<TokenInfoRespVO> list1 = new ArrayList<TokenInfoRespVO>( list.size() );
        for ( TokenInfoDO tokenInfoDO : list ) {
            list1.add( convert( tokenInfoDO ) );
        }

        return list1;
    }

    @Override
    public PageResult<TokenInfoRespVO> convertPage(PageResult<TokenInfoDO> page) {
        if ( page == null ) {
            return null;
        }

        PageResult<TokenInfoRespVO> pageResult = new PageResult<TokenInfoRespVO>();

        pageResult.setList( convertList( page.getList() ) );
        pageResult.setTotal( page.getTotal() );

        return pageResult;
    }

    @Override
    public List<TokenInfoExcelVO> convertList02(List<TokenInfoDO> list) {
        if ( list == null ) {
            return null;
        }

        List<TokenInfoExcelVO> list1 = new ArrayList<TokenInfoExcelVO>( list.size() );
        for ( TokenInfoDO tokenInfoDO : list ) {
            list1.add( tokenInfoDOToTokenInfoExcelVO( tokenInfoDO ) );
        }

        return list1;
    }

    protected TokenInfoExcelVO tokenInfoDOToTokenInfoExcelVO(TokenInfoDO tokenInfoDO) {
        if ( tokenInfoDO == null ) {
            return null;
        }

        TokenInfoExcelVO tokenInfoExcelVO = new TokenInfoExcelVO();

        tokenInfoExcelVO.setId( tokenInfoDO.getId() );
        tokenInfoExcelVO.setBaseCcy( tokenInfoDO.getBaseCcy() );
        tokenInfoExcelVO.setCtMult( tokenInfoDO.getCtMult() );
        tokenInfoExcelVO.setListDate( tokenInfoDO.getListDate() );
        tokenInfoExcelVO.setCtVal( tokenInfoDO.getCtVal() );
        tokenInfoExcelVO.setCtValCcy( tokenInfoDO.getCtValCcy() );
        tokenInfoExcelVO.setExpDate( tokenInfoDO.getExpDate() );
        tokenInfoExcelVO.setInstFamily( tokenInfoDO.getInstFamily() );
        tokenInfoExcelVO.setInstId( tokenInfoDO.getInstId() );
        tokenInfoExcelVO.setInstType( tokenInfoDO.getInstType() );
        tokenInfoExcelVO.setLever( tokenInfoDO.getLever() );
        tokenInfoExcelVO.setLotSz( tokenInfoDO.getLotSz() );
        tokenInfoExcelVO.setMaxIcebergSz( tokenInfoDO.getMaxIcebergSz() );
        tokenInfoExcelVO.setMaxLmtSz( tokenInfoDO.getMaxLmtSz() );
        tokenInfoExcelVO.setMaxMktSz( tokenInfoDO.getMaxMktSz() );
        tokenInfoExcelVO.setMaxStopSz( tokenInfoDO.getMaxStopSz() );
        tokenInfoExcelVO.setMaxTriggerSz( tokenInfoDO.getMaxTriggerSz() );
        tokenInfoExcelVO.setMaxTwapSz( tokenInfoDO.getMaxTwapSz() );
        tokenInfoExcelVO.setMinSz( tokenInfoDO.getMinSz() );
        tokenInfoExcelVO.setOptType( tokenInfoDO.getOptType() );
        tokenInfoExcelVO.setQuoteCcy( tokenInfoDO.getQuoteCcy() );
        tokenInfoExcelVO.setSettleCcy( tokenInfoDO.getSettleCcy() );
        tokenInfoExcelVO.setState( tokenInfoDO.getState() );
        tokenInfoExcelVO.setStk( tokenInfoDO.getStk() );
        tokenInfoExcelVO.setTickSz( tokenInfoDO.getTickSz() );
        tokenInfoExcelVO.setUly( tokenInfoDO.getUly() );
        tokenInfoExcelVO.setExchangeType( tokenInfoDO.getExchangeType() );

        return tokenInfoExcelVO;
    }
}
