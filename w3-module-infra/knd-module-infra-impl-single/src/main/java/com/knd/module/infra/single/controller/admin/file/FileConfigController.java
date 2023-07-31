package com.knd.module.infra.single.controller.admin.file;


import com.knd.framework.common.pojo.CommonResult;

import com.knd.framework.common.pojo.PageResult;
import com.knd.module.infra.api.dal.dataobject.file.FileConfigDO;
import com.knd.module.infra.single.controller.admin.file.vo.config.FileConfigCreateReqVO;
import com.knd.module.infra.single.controller.admin.file.vo.config.FileConfigPageReqVO;
import com.knd.module.infra.single.controller.admin.file.vo.config.FileConfigRespVO;
import com.knd.module.infra.single.controller.admin.file.vo.config.FileConfigUpdateReqVO;
import com.knd.module.infra.single.convert.file.FileConfigConvert;
import com.knd.module.infra.single.service.file.FileConfigService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.knd.framework.common.pojo.CommonResult.success;


/**
 * 管理后台 - 文件配置
 */
@RestController
@RequestMapping("/infra/file-config")
@Validated
public class FileConfigController {

    @Resource
    private FileConfigService fileConfigService;

    /**
     * 创建文件配置
     *
     * @param createReqVO
     * @return
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('infra:file-config:create')")
    public CommonResult<Long> createFileConfig(@Valid @RequestBody FileConfigCreateReqVO createReqVO) {
        return success(fileConfigService.createFileConfig(createReqVO));
    }

    /**
     * 更新文件配置
     *
     * @param updateReqVO
     * @return
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('infra:file-config:update')")
    public CommonResult<Boolean> updateFileConfig(@Valid @RequestBody FileConfigUpdateReqVO updateReqVO) {
        fileConfigService.updateFileConfig(updateReqVO);
        return success(true);
    }

    /**
     * 更新文件配置为 Master
     *
     * @param id
     * @return
     */
    @PutMapping("/update-master")
    @PreAuthorize("@ss.hasPermission('infra:file-config:update')")
    public CommonResult<Boolean> updateFileConfigMaster(@RequestParam("id") Long id) {
        fileConfigService.updateFileConfigMaster(id);
        return success(true);
    }

    /**
     * 删除文件配置
     *
     * @param id description = "编号", required = true
     * @return
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('infra:file-config:delete')")
    public CommonResult<Boolean> deleteFileConfig(@RequestParam("id") Long id) {
        fileConfigService.deleteFileConfig(id);
        return success(true);
    }

    /**
     * 获得文件配置 TODO
     *
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('infra:file-config:query')")
    public CommonResult<FileConfigRespVO> getFileConfig(@RequestParam("id") Long id) {
//        FileConfigDO fileConfig = fileConfigService.getFileConfig(id);
//        return success(FileConfigConvert.INSTANCE.convert(fileConfig));
        return null;
    }

    /**
     * 获得文件配置分页
     *
     * @param pageVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('infra:file-config:query')")
    public CommonResult<PageResult<FileConfigRespVO>> getFileConfigPage(@Valid FileConfigPageReqVO pageVO) {
        PageResult<FileConfigDO> pageResult = fileConfigService.getFileConfigPage(pageVO);
        return success(FileConfigConvert.INSTANCE.convertPage(pageResult));
    }

    /**
     * 测试文件配置是否正确
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/test")
    @PreAuthorize("@ss.hasPermission('infra:file-config:query')")
    public CommonResult<String> testFileConfig(@RequestParam("id") Long id) throws Exception {
        String url = fileConfigService.testFileConfig(id);
        return success(url);
    }
}
