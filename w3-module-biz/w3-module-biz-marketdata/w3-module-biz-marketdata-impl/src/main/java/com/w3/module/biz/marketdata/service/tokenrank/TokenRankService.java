package com.w3.module.biz.marketdata.service.tokenrank;

import java.util.*;
import javax.validation.*;
import com.w3.framework.common.pojo.PageResult;
import com.w3.module.biz.marketdata.controller.tokenrank.vo.TokenRankCreateReqVO;
import com.w3.module.biz.marketdata.controller.tokenrank.vo.TokenRankExportReqVO;
import com.w3.module.biz.marketdata.controller.tokenrank.vo.TokenRankPageReqVO;
import com.w3.module.biz.marketdata.controller.tokenrank.vo.TokenRankUpdateReqVO;
import com.w3.module.biz.marketdata.dal.dataobject.TokenRankDO;

/**
 * TOKEN排名信息 Service 接口
 *
 * @author 芋道源码
 */
public interface TokenRankService {

    /**
     * 创建TOKEN排名信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createTokenRank(@Valid TokenRankCreateReqVO createReqVO);

    /**
     * 更新TOKEN排名信息
     *
     * @param updateReqVO 更新信息
     */
    void updateTokenRank(@Valid TokenRankUpdateReqVO updateReqVO);

    /**
     * 删除TOKEN排名信息
     *
     * @param id 编号
     */
    void deleteTokenRank(Integer id);

    /**
     * 获得TOKEN排名信息
     *
     * @param id 编号
     * @return TOKEN排名信息
     */
    TokenRankDO getTokenRank(Integer id);

    /**
     * 获得TOKEN排名信息列表
     *
     * @param ids 编号
     * @return TOKEN排名信息列表
     */
    List<TokenRankDO> getTokenRankList(Collection<Integer> ids);

    /**
     * 获得TOKEN排名信息分页
     *
     * @param pageReqVO 分页查询
     * @return TOKEN排名信息分页
     */
    PageResult<TokenRankDO> getTokenRankPage(TokenRankPageReqVO pageReqVO);

    /**
     * 获得TOKEN排名信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return TOKEN排名信息列表
     */
    List<TokenRankDO> getTokenRankList(TokenRankExportReqVO exportReqVO);

}
