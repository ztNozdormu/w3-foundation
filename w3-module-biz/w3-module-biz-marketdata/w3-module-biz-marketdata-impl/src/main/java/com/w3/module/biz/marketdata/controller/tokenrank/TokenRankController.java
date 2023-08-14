package com.w3.module.biz.marketdata.controller.tokenrank;

import com.w3.framework.common.pojo.PageResult;
import com.w3.module.biz.marketdata.controller.tokenrank.vo.*;
import com.w3.module.biz.marketdata.convert.tokenrank.TokenRankConvert;
import com.w3.module.biz.marketdata.dal.dataobject.TokenRankDO;
import com.w3.module.biz.marketdata.service.tokenrank.TokenRankService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import com.w3.framework.common.pojo.CommonResult;
import static com.w3.framework.common.pojo.CommonResult.success;

import com.w3.framework.excel.core.util.ExcelUtils;

import com.w3.framework.operatelog.core.annotations.OperateLog;
import static com.w3.framework.operatelog.core.enums.OperateTypeEnum.*;


/**
* 管理后台 - TOKEN排名信息
*
* @author auto
*/
@RestController
@RequestMapping("/mk/token-rank")
@Validated
public class TokenRankController {

    @Resource
    private TokenRankService tokenRankService;

    /**
     * 创建TOKEN排名信息
     * @param createReqVO
     * @return
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('mk:token-rank:create')")
    public CommonResult<Integer> createTokenRank(@Valid @RequestBody TokenRankCreateReqVO createReqVO) {
        return success(tokenRankService.createTokenRank(createReqVO));
    }
    /**
     * 更新TOKEN排名信息
     * @param updateReqVO
     * @return
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('mk:token-rank:update')")
    public CommonResult<Boolean> updateTokenRank(@Valid @RequestBody TokenRankUpdateReqVO updateReqVO) {
        tokenRankService.updateTokenRank(updateReqVO);
        return success(true);
    }

    /**
     * 删除TOKEN排名信息
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('mk:token-rank:delete')")
    public CommonResult<Boolean> deleteTokenRank(@RequestParam("id") Integer id) {
        tokenRankService.deleteTokenRank(id);
        return success(true);
    }

    /**
     * 获得TOKEN排名信息
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('mk:token-rank:query')")
    public CommonResult<TokenRankRespVO> getTokenRank(@RequestParam("id") Integer id) {
        TokenRankDO tokenRank = tokenRankService.getTokenRank(id);
        return success(TokenRankConvert.INSTANCE.convert(tokenRank));
    }

    /**
     * 获得TOKEN排名信息列表
     * @param ids description = "编号列表", required = true, example = "1024,2048"
     * @return
     */
    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermission('mk:token-rank:query')")
    public CommonResult<List<TokenRankRespVO>> getTokenRankList(@RequestParam("ids") Collection<Integer> ids) {
        List<TokenRankDO> list = tokenRankService.getTokenRankList(ids);
        return success(TokenRankConvert.INSTANCE.convertList(list));
    }

    /**
     * 获得TOKEN排名信息分页
     * @param pageVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('mk:token-rank:query')")
    public CommonResult<PageResult<TokenRankRespVO>> getTokenRankPage(@Valid TokenRankPageReqVO pageVO) {
        PageResult<TokenRankDO> pageResult = tokenRankService.getTokenRankPage(pageVO);
        return success(TokenRankConvert.INSTANCE.convertPage(pageResult));
    }

    /**
     * 导出TOKEN排名信息 Excel
     * @param exportReqVO
     * @param response
     * @throws IOException
     */
    @GetMapping("/export-excel")
    @PreAuthorize("@ss.hasPermission('mk:token-rank:export')")
    @OperateLog(type = EXPORT)
    public void exportTokenRankExcel(@Valid TokenRankExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<TokenRankDO> list = tokenRankService.getTokenRankList(exportReqVO);
        // 导出 Excel
        List<TokenRankExcelVO> datas = TokenRankConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "TOKEN排名信息.xls", "数据", TokenRankExcelVO.class, datas);
    }

}
