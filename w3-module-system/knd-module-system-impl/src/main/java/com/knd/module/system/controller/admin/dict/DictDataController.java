package com.knd.module.system.controller.admin.dict;


import com.knd.framework.common.pojo.CommonResult;
import com.knd.framework.common.pojo.PageResult;
import com.knd.framework.excel.core.util.ExcelUtils;
import com.knd.framework.operatelog.core.annotations.OperateLog;
import com.knd.module.system.controller.admin.dict.vo.data.*;
import com.knd.module.system.convert.dict.DictDataConvert;
import com.knd.module.system.dal.dataobject.dict.DictDataDO;
import com.knd.module.system.service.dict.DictDataService;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static com.knd.framework.common.pojo.CommonResult.success;
import static com.knd.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;


/**
 * 管理后台 - 字典数据
 */
@RestController
@RequestMapping("/system/dict-data")
@Validated
public class DictDataController {

    @Resource
    private DictDataService dictDataService;

    /**
     * 新增字典数据
     * @param reqVO
     * @return
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:dict:create')")
    public CommonResult<Long> createDictData(@Valid @RequestBody DictDataCreateReqVO reqVO) {
        Long dictDataId = dictDataService.createDictData(reqVO);
        return success(dictDataId);
    }

    /**
     * 修改字典数据
     * @param reqVO
     * @return
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:dict:update')")
    public CommonResult<Boolean> updateDictData(@Valid @RequestBody DictDataUpdateReqVO reqVO) {
        dictDataService.updateDictData(reqVO);
        return success(true);
    }

    /**
     * 删除字典数据
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:dict:delete')")
    public CommonResult<Boolean> deleteDictData(Long id) {
        dictDataService.deleteDictData(id);
        return success(true);
    }

    /**
     * 获得全部字典数据列表 description = "一般用于管理后台缓存字典数据在本地"
     * @return
     */
    @GetMapping("/list-all-simple")
    // 无需添加权限认证，因为前端全局都需要
    public CommonResult<List<DictDataSimpleRespVO>> getSimpleDictDataList() {
        List<DictDataDO> list = dictDataService.getDictDataList();
        return success(DictDataConvert.INSTANCE.convertList(list));
    }

    /**
     * 获得字典类型的分页列表
     * @param reqVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:dict:query')")
    public CommonResult<PageResult<DictDataRespVO>> getDictTypePage(@Valid DictDataPageReqVO reqVO) {
        return success(DictDataConvert.INSTANCE.convertPage(dictDataService.getDictDataPage(reqVO)));
    }

    /**
     * 查询字典数据详细
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @GetMapping(value = "/get")
    @PreAuthorize("@ss.hasPermission('system:dict:query')")
    public CommonResult<DictDataRespVO> getDictData(@RequestParam("id") Long id) {
        return success(DictDataConvert.INSTANCE.convert(dictDataService.getDictData(id)));
    }

    /**
     * 导出字典数据
     * @param response
     * @param reqVO
     * @throws IOException
     */
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPermission('system:dict:export')")
    @OperateLog(type = EXPORT)
    public void export(HttpServletResponse response, @Valid DictDataExportReqVO reqVO) throws IOException {
        List<DictDataDO> list = dictDataService.getDictDataList(reqVO);
        List<DictDataExcelVO> data = DictDataConvert.INSTANCE.convertList02(list);
        // 输出
        ExcelUtils.write(response, "字典数据.xls", "数据列表", DictDataExcelVO.class, data);
    }

}
