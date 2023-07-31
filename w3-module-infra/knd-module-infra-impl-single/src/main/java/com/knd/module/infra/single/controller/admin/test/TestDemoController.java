package com.knd.module.infra.single.controller.admin.test;


import com.knd.framework.common.pojo.CommonResult;
import com.knd.framework.common.pojo.PageResult;
import com.knd.framework.excel.core.util.ExcelUtils;
import com.knd.framework.operatelog.core.annotations.OperateLog;
import com.knd.module.infra.api.dal.dataobject.test.TestDemoDO;
import com.knd.module.infra.single.controller.admin.test.vo.*;
import com.knd.module.infra.single.convert.test.TestDemoConvert;
import com.knd.module.infra.single.service.test.TestDemoService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static com.knd.framework.common.pojo.CommonResult.success;
import static com.knd.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;


/**
 * 管理后台 - 字典类型
 */
@RestController
@RequestMapping("/infra/test-demo")
@Validated
public class TestDemoController {

    @Resource
    private TestDemoService testDemoService;

    /**
     * 创建字典类型
     * @param createReqVO
     * @return
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('infra:test-demo:create')")
    public CommonResult<Long> createTestDemo(@Valid @RequestBody TestDemoCreateReqVO createReqVO) {
        return success(testDemoService.createTestDemo(createReqVO));
    }

    /**
     * 更新字典类型
     * @param updateReqVO
     * @return
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('infra:test-demo:update')")
    public CommonResult<Boolean> updateTestDemo(@Valid @RequestBody TestDemoUpdateReqVO updateReqVO) {
        testDemoService.updateTestDemo(updateReqVO);
        return success(true);
    }

    /**
     * 删除字典类型
     * @param id description = "编号", required = true
     * @return
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('infra:test-demo:delete')")
    public CommonResult<Boolean> deleteTestDemo(@RequestParam("id") Long id) {
        testDemoService.deleteTestDemo(id);
        return success(true);
    }

    /**
     * 获得字典类型
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('infra:test-demo:query')")
    public CommonResult<TestDemoRespVO> getTestDemo(@RequestParam("id") Long id) {
        TestDemoDO testDemo = testDemoService.getTestDemo(id);
        return success(TestDemoConvert.INSTANCE.convert(testDemo));
    }

    /**
     * 获得字典类型列表
     * @param ids description = "编号列表", required = true, example = "1024,2048"
     * @return
     */
    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermission('infra:test-demo:query')")
    public CommonResult<List<TestDemoRespVO>> getTestDemoList(@RequestParam("ids") Collection<Long> ids) {
        List<TestDemoDO> list = testDemoService.getTestDemoList(ids);
        return success(TestDemoConvert.INSTANCE.convertList(list));
    }

    /**
     * 获得字典类型分页
     * @param pageVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('infra:test-demo:query')")    public CommonResult<PageResult<TestDemoRespVO>> getTestDemoPage(@Valid TestDemoPageReqVO pageVO) {
        PageResult<TestDemoDO> pageResult = testDemoService.getTestDemoPage(pageVO);
        return success(TestDemoConvert.INSTANCE.convertPage(pageResult));
    }

    /**
     * 导出字典类型 Excel
     * @param exportReqVO
     * @param response
     * @throws IOException
     */
    @GetMapping("/export-excel")
    @PreAuthorize("@ss.hasPermission('infra:test-demo:export')")    @OperateLog(type = EXPORT)
    public void exportTestDemoExcel(@Valid TestDemoExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<TestDemoDO> list = testDemoService.getTestDemoList(exportReqVO);
        // 导出 Excel
        List<TestDemoExcelVO> datas = TestDemoConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "字典类型.xls", "数据", TestDemoExcelVO.class, datas);
    }

}
