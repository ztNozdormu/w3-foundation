package com.knd.module.infra.single.controller.admin.config;


import com.knd.framework.common.pojo.CommonResult;
import com.knd.framework.common.pojo.PageResult;
import com.knd.framework.excel.core.util.ExcelUtils;
import com.knd.framework.operatelog.core.annotations.OperateLog;
import com.knd.module.infra.api.dal.dataobject.config.ConfigDO;
import com.knd.module.infra.api.enums.ErrorCodeConstants;
import com.knd.module.infra.single.controller.admin.config.vo.*;
import com.knd.module.infra.single.convert.config.ConfigConvert;
import com.knd.module.infra.single.service.config.ConfigService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static com.knd.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.knd.framework.common.pojo.CommonResult.success;
import static com.knd.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;


/**
 * 管理后台 - 参数配置
 */
@RestController
@RequestMapping("/infra/config")
@Validated
public class ConfigController {

    @Resource
    private ConfigService configService;

    /**
     * 创建参数配置
     * @param reqVO
     * @return
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('infra:config:create')")
    public CommonResult<Long> createConfig(@Valid @RequestBody ConfigCreateReqVO reqVO) {
        return success(configService.createConfig(reqVO));
    }

    /**
     * 修改参数配置
     * @param reqVO
     * @return
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('infra:config:update')")
    public CommonResult<Boolean> updateConfig(@Valid @RequestBody ConfigUpdateReqVO reqVO) {
        configService.updateConfig(reqVO);
        return success(true);
    }

    /**
     * 删除参数配置
     * @param id 编号 example = "1024"
     * @return
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('infra:config:delete')")
    public CommonResult<Boolean> deleteConfig(@RequestParam("id") Long id) {
        configService.deleteConfig(id);
        return success(true);
    }

    /**
     * 获得参数配置
     * @param id 编号 example = "1024"
     * @return
     */
    @GetMapping(value = "/get")
    @PreAuthorize("@ss.hasPermission('infra:config:query')")
    public CommonResult<ConfigRespVO> getConfig(@RequestParam("id") Long id) {
        return success(ConfigConvert.INSTANCE.convert(configService.getConfig(id)));
    }

    /**
     * 根据参数键名查询参数值  description = "不可见的配置，不允许返回给前端"
     * @param key  参数键 example = "yunai.biz.username"
     * @return
     */
    @GetMapping(value = "/get-value-by-key")
    public CommonResult<String> getConfigKey(@RequestParam("key") String key) {
        ConfigDO config = configService.getConfigByKey(key);
        if (config == null) {
            return success(null);
        }
        if (!config.getVisible()) {
            throw exception(ErrorCodeConstants.CONFIG_GET_VALUE_ERROR_IF_VISIBLE);
        }
        return success(config.getValue());
    }

    /**
     * 获取参数配置分页
     * @param reqVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('infra:config:query')")
    public CommonResult<PageResult<ConfigRespVO>> getConfigPage(@Valid ConfigPageReqVO reqVO) {
        PageResult<ConfigDO> page = configService.getConfigPage(reqVO);
        return success(ConfigConvert.INSTANCE.convertPage(page));
    }

    /**
     * 导出参数配置
     * @param reqVO
     * @param response
     * @throws IOException
     */
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPermission('infra:config:export')")
    @OperateLog(type = EXPORT)
    public void exportConfig(@Valid ConfigExportReqVO reqVO,
                             HttpServletResponse response) throws IOException {
        List<ConfigDO> list = configService.getConfigList(reqVO);
        // 拼接数据
        List<ConfigExcelVO> datas = ConfigConvert.INSTANCE.convertList(list);
        // 输出
        ExcelUtils.write(response, "参数配置.xls", "数据", ConfigExcelVO.class, datas);
    }

}
