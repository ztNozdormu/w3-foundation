package com.w3.module.biz.marketdata.service.tokenrank;

import com.w3.framework.common.pojo.PageResult;
import com.w3.module.biz.marketdata.controller.tokenrank.vo.TokenRankCreateReqVO;
import com.w3.module.biz.marketdata.controller.tokenrank.vo.TokenRankExportReqVO;
import com.w3.module.biz.marketdata.controller.tokenrank.vo.TokenRankPageReqVO;
import com.w3.module.biz.marketdata.controller.tokenrank.vo.TokenRankUpdateReqVO;
import com.w3.module.biz.marketdata.convert.tokenrank.TokenRankConvert;
import com.w3.module.biz.marketdata.dal.dataobject.TokenRankDO;
import com.w3.module.biz.marketdata.dal.mysql.tokenrank.TokenRankMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;

import static com.w3.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.w3.module.biz.marketdata.enums.ErrorCodeConstants.TOKEN_RANK_NOT_EXISTS;

/**
 * TOKEN排名信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class TokenRankServiceImpl implements TokenRankService {

    @Resource
    private TokenRankMapper tokenRankMapper;

    @Override
    public Integer createTokenRank(TokenRankCreateReqVO createReqVO) {
        // 插入
        TokenRankDO tokenRank = TokenRankConvert.INSTANCE.convert(createReqVO);
        tokenRankMapper.insert(tokenRank);
        // 返回
        return tokenRank.getId();
    }

    @Override
    public void updateTokenRank(TokenRankUpdateReqVO updateReqVO) {
        // 校验存在
        validateTokenRankExists(updateReqVO.getId());
        // 更新
        TokenRankDO updateObj = TokenRankConvert.INSTANCE.convert(updateReqVO);
        tokenRankMapper.updateById(updateObj);
    }

    @Override
    public void deleteTokenRank(Integer id) {
        // 校验存在
        validateTokenRankExists(id);
        // 删除
        tokenRankMapper.deleteById(id);
    }

    private void validateTokenRankExists(Integer id) {
        if (tokenRankMapper.selectById(id) == null) {
            throw exception(TOKEN_RANK_NOT_EXISTS);
        }
    }

    @Override
    public TokenRankDO getTokenRank(Integer id) {
        return tokenRankMapper.selectById(id);
    }

    @Override
    public List<TokenRankDO> getTokenRankList(Collection<Integer> ids) {
        return tokenRankMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<TokenRankDO> getTokenRankPage(TokenRankPageReqVO pageReqVO) {
        return tokenRankMapper.selectPage(pageReqVO);
    }

    @Override
    public List<TokenRankDO> getTokenRankList(TokenRankExportReqVO exportReqVO) {
        return tokenRankMapper.selectList(exportReqVO);
    }

}
