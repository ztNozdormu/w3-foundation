package com.w3.module.biz.marketdata.service.tokeninfo;

import java.util.*;
import javax.validation.*;
import com.w3.framework.common.pojo.PageResult;
import com.w3.module.biz.marketdata.controller.tokeninfo.vo.TokenInfoCreateReqVO;
import com.w3.module.biz.marketdata.controller.tokeninfo.vo.TokenInfoExportReqVO;
import com.w3.module.biz.marketdata.controller.tokeninfo.vo.TokenInfoPageReqVO;
import com.w3.module.biz.marketdata.controller.tokeninfo.vo.TokenInfoUpdateReqVO;
import com.w3.module.biz.marketdata.dal.dataobject.TokenInfoDO;

/**
 * TOKEN基本信息 Service 接口
 *
 * @author 芋道源码
 */
public interface TokenInfoService {

    /**
     * 创建TOKEN基本信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTokenInfo(@Valid TokenInfoCreateReqVO createReqVO);

    /**
     * 更新TOKEN基本信息
     *
     * @param updateReqVO 更新信息
     */
    void updateTokenInfo(@Valid TokenInfoUpdateReqVO updateReqVO);

    /**
     * 删除TOKEN基本信息
     *
     * @param id 编号
     */
    void deleteTokenInfo(Long id);

    /**
     * 获得TOKEN基本信息
     *
     * @param id 编号
     * @return TOKEN基本信息
     */
    TokenInfoDO getTokenInfo(Long id);

    /**
     * 获得TOKEN基本信息列表
     *
     * @param ids 编号
     * @return TOKEN基本信息列表
     */
    List<TokenInfoDO> getTokenInfoList(Collection<Long> ids);

    /**
     * 获得TOKEN基本信息分页
     *
     * @param pageReqVO 分页查询
     * @return TOKEN基本信息分页
     */
    PageResult<TokenInfoDO> getTokenInfoPage(TokenInfoPageReqVO pageReqVO);

    /**
     * 获得TOKEN基本信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return TOKEN基本信息列表
     */
    List<TokenInfoDO> getTokenInfoList(TokenInfoExportReqVO exportReqVO);

}
