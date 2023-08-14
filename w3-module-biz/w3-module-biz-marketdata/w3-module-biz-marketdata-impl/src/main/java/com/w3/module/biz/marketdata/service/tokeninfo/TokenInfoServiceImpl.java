package com.w3.module.biz.marketdata.service.tokeninfo;

import com.w3.module.biz.marketdata.controller.tokeninfo.vo.TokenInfoCreateReqVO;
import com.w3.module.biz.marketdata.controller.tokeninfo.vo.TokenInfoExportReqVO;
import com.w3.module.biz.marketdata.controller.tokeninfo.vo.TokenInfoPageReqVO;
import com.w3.module.biz.marketdata.controller.tokeninfo.vo.TokenInfoUpdateReqVO;
import com.w3.module.biz.marketdata.convert.tokeninfo.TokenInfoConvert;
import com.w3.module.biz.marketdata.dal.dataobject.TokenInfoDO;
import com.w3.module.biz.marketdata.dal.mysql.tokeninfo.TokenInfoMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import com.w3.framework.common.pojo.PageResult;

import static com.w3.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.w3.module.biz.marketdata.enums.ErrorCodeConstants.TOKEN_INFO_NOT_EXISTS;

/**
 * TOKEN基本信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class TokenInfoServiceImpl implements TokenInfoService {

    @Resource
    private TokenInfoMapper tokenInfoMapper;

    @Override
    public Long createTokenInfo(TokenInfoCreateReqVO createReqVO) {
        // 插入
        TokenInfoDO tokenInfo = TokenInfoConvert.INSTANCE.convert(createReqVO);
        tokenInfoMapper.insert(tokenInfo);
        // 返回
        return tokenInfo.getId();
    }

    @Override
    public void updateTokenInfo(TokenInfoUpdateReqVO updateReqVO) {
        // 校验存在
        validateTokenInfoExists(updateReqVO.getId());
        // 更新
        TokenInfoDO updateObj = TokenInfoConvert.INSTANCE.convert(updateReqVO);
        tokenInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteTokenInfo(Long id) {
        // 校验存在
        validateTokenInfoExists(id);
        // 删除
        tokenInfoMapper.deleteById(id);
    }

    private void validateTokenInfoExists(Long id) {
        if (tokenInfoMapper.selectById(id) == null) {
            throw exception(TOKEN_INFO_NOT_EXISTS);
        }
    }

    @Override
    public TokenInfoDO getTokenInfo(Long id) {
        return tokenInfoMapper.selectById(id);
    }

    @Override
    public List<TokenInfoDO> getTokenInfoList(Collection<Long> ids) {
        return tokenInfoMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<TokenInfoDO> getTokenInfoPage(TokenInfoPageReqVO pageReqVO) {
        return tokenInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<TokenInfoDO> getTokenInfoList(TokenInfoExportReqVO exportReqVO) {
        return tokenInfoMapper.selectList(exportReqVO);
    }

}
