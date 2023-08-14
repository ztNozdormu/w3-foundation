package com.w3.module.biz.marketdata.controller.tokeninfo;

import com.w3.framework.common.pojo.PageResult;
import com.w3.module.biz.marketdata.controller.tokeninfo.vo.*;
import com.w3.module.biz.marketdata.convert.tokeninfo.TokenInfoConvert;
import com.w3.module.biz.marketdata.dal.dataobject.TokenInfoDO;
import com.w3.module.biz.marketdata.service.tokeninfo.TokenInfoService;
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
* 管理后台 - TOKEN基本信息
*
* @author auto
*/
@RestController
@RequestMapping("/mk/token-info")
@Validated
public class TokenInfoController {

    @Resource
    private TokenInfoService tokenInfoService;

    /**
     * 创建TOKEN基本信息
     * @param createReqVO
     * @return
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('mk:token-info:create')")
    public CommonResult<Long> createTokenInfo(@Valid @RequestBody TokenInfoCreateReqVO createReqVO) {
        return success(tokenInfoService.createTokenInfo(createReqVO));
    }
    /**
     * 更新TOKEN基本信息
     * @param updateReqVO
     * @return
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('mk:token-info:update')")
    public CommonResult<Boolean> updateTokenInfo(@Valid @RequestBody TokenInfoUpdateReqVO updateReqVO) {
        tokenInfoService.updateTokenInfo(updateReqVO);
        return success(true);
    }

    /**
     * 删除TOKEN基本信息
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('mk:token-info:delete')")
    public CommonResult<Boolean> deleteTokenInfo(@RequestParam("id") Long id) {
        tokenInfoService.deleteTokenInfo(id);
        return success(true);
    }

    /**
     * 获得TOKEN基本信息
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('mk:token-info:query')")
    public CommonResult<TokenInfoRespVO> getTokenInfo(@RequestParam("id") Long id) {
        TokenInfoDO tokenInfo = tokenInfoService.getTokenInfo(id);
        return success(TokenInfoConvert.INSTANCE.convert(tokenInfo));
    }

    /**
     * 获得TOKEN基本信息列表
     * @param ids description = "编号列表", required = true, example = "1024,2048"
     * @return
     */
    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermission('mk:token-info:query')")
    public CommonResult<List<TokenInfoRespVO>> getTokenInfoList(@RequestParam("ids") Collection<Long> ids) {
        List<TokenInfoDO> list = tokenInfoService.getTokenInfoList(ids);
        return success(TokenInfoConvert.INSTANCE.convertList(list));
    }

    /**
     * 获得TOKEN基本信息分页
     * @param pageVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('mk:token-info:query')")
    public CommonResult<PageResult<TokenInfoRespVO>> getTokenInfoPage(@Valid TokenInfoPageReqVO pageVO) {
        PageResult<TokenInfoDO> pageResult = tokenInfoService.getTokenInfoPage(pageVO);
        return success(TokenInfoConvert.INSTANCE.convertPage(pageResult));
    }

    /**
     * 导出TOKEN基本信息 Excel
     * @param exportReqVO
     * @param response
     * @throws IOException
     */
    @GetMapping("/export-excel")
    @PreAuthorize("@ss.hasPermission('mk:token-info:export')")
    @OperateLog(type = EXPORT)
    public void exportTokenInfoExcel(@Valid TokenInfoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<TokenInfoDO> list = tokenInfoService.getTokenInfoList(exportReqVO);
        // 导出 Excel
        List<TokenInfoExcelVO> datas = TokenInfoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "TOKEN基本信息.xls", "数据", TokenInfoExcelVO.class, datas);
    }

}
