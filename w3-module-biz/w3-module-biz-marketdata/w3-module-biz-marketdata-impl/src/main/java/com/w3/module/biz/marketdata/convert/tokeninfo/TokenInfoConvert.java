package com.w3.module.biz.marketdata.convert.tokeninfo;

import java.util.*;

import com.w3.framework.common.pojo.PageResult;

import com.w3.module.biz.marketdata.controller.tokeninfo.vo.TokenInfoCreateReqVO;
import com.w3.module.biz.marketdata.controller.tokeninfo.vo.TokenInfoExcelVO;
import com.w3.module.biz.marketdata.controller.tokeninfo.vo.TokenInfoRespVO;
import com.w3.module.biz.marketdata.controller.tokeninfo.vo.TokenInfoUpdateReqVO;
import com.w3.module.biz.marketdata.dal.dataobject.TokenInfoDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TOKEN基本信息 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface TokenInfoConvert {

    TokenInfoConvert INSTANCE = Mappers.getMapper(TokenInfoConvert.class);

    TokenInfoDO convert(TokenInfoCreateReqVO bean);

    TokenInfoDO convert(TokenInfoUpdateReqVO bean);

    TokenInfoRespVO convert(TokenInfoDO bean);

    List<TokenInfoRespVO> convertList(List<TokenInfoDO> list);

    PageResult<TokenInfoRespVO> convertPage(PageResult<TokenInfoDO> page);

    List<TokenInfoExcelVO> convertList02(List<TokenInfoDO> list);

}
