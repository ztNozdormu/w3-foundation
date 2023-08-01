package com.w3.module.infra.controller.admin.db;


import com.w3.framework.codegen.domain.db.DataSourceConfigDO;
import com.w3.framework.common.pojo.CommonResult;
import com.w3.module.infra.controller.admin.db.vo.DataSourceConfigCreateReqVO;
import com.w3.module.infra.controller.admin.db.vo.DataSourceConfigRespVO;
import com.w3.module.infra.controller.admin.db.vo.DataSourceConfigUpdateReqVO;
import com.w3.module.infra.convert.db.DataSourceConfigConvert;
import com.w3.module.infra.service.db.DataSourceConfigService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static com.w3.framework.common.pojo.CommonResult.success;


/**
 * 管理后台 - 数据源配置
 */
@RestController
@RequestMapping("/infra/data-source-config")
@Validated
public class DataSourceConfigController {

    @Resource
    private DataSourceConfigService dataSourceConfigService;

    /**
     * 创建数据源配置
     * @param createReqVO
     * @return
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('infra:data-source-config:create')")
    public CommonResult<Long> createDataSourceConfig(@Valid @RequestBody DataSourceConfigCreateReqVO createReqVO) {
        return success(dataSourceConfigService.createDataSourceConfig(createReqVO));
    }

    /**
     * 更新数据源配置
     * @param updateReqVO
     * @return
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('infra:data-source-config:update')")
    public CommonResult<Boolean> updateDataSourceConfig(@Valid @RequestBody DataSourceConfigUpdateReqVO updateReqVO) {
        dataSourceConfigService.updateDataSourceConfig(updateReqVO);
        return success(true);
    }

    /**
     * 删除数据源配置
     * @param id description = "编号", required = true
     * @return
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('infra:data-source-config:delete')")
    public CommonResult<Boolean> deleteDataSourceConfig(@RequestParam("id") Long id) {
        dataSourceConfigService.deleteDataSourceConfig(id);
        return success(true);
    }

    /**
     * 获得数据源配置
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('infra:data-source-config:query')")
    public CommonResult<DataSourceConfigRespVO> getDataSourceConfig(@RequestParam("id") Long id) {
        DataSourceConfigDO dataSourceConfig = dataSourceConfigService.getDataSourceConfig(id);
        return success(DataSourceConfigConvert.INSTANCE.convert(dataSourceConfig));
    }

    /**
     * 获得数据源配置列表
     * @return
     */
    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermission('infra:data-source-config:query')")
    public CommonResult<List<DataSourceConfigRespVO>> getDataSourceConfigList() {
        List<DataSourceConfigDO> list = dataSourceConfigService.getDataSourceConfigList();
        return success(DataSourceConfigConvert.INSTANCE.convertList(list));
    }

}
