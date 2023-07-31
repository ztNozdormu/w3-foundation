package com.w3.module.system.controller.admin.tenant;


import com.w3.framework.common.enums.CommonStatusEnum;
import com.w3.framework.common.pojo.CommonResult;
import com.w3.framework.common.pojo.PageResult;
import com.w3.module.system.controller.admin.tenant.vo.packages.*;
import com.w3.module.system.convert.tenant.TenantPackageConvert;
import com.w3.module.system.dal.dataobject.tenant.TenantPackageDO;
import com.w3.module.system.service.tenant.TenantPackageService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static com.w3.framework.common.pojo.CommonResult.success;


/**
 * 管理后台 - 租户套餐
 */
@RestController
@RequestMapping("/system/tenant-package")
@Validated
public class TenantPackageController {

    @Resource
    private TenantPackageService tenantPackageService;

    /**
     * 创建租户套餐
     *
     * @param createReqVO
     * @return
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:tenant-package:create')")
    public CommonResult<Long> createTenantPackage(@Valid @RequestBody TenantPackageCreateReqVO createReqVO) {
        return success(tenantPackageService.createTenantPackage(createReqVO));
    }

    /**
     * 更新租户套餐
     *
     * @param updateReqVO
     * @return
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:tenant-package:update')")
    public CommonResult<Boolean> updateTenantPackage(@Valid @RequestBody TenantPackageUpdateReqVO updateReqVO) {
        tenantPackageService.updateTenantPackage(updateReqVO);
        return success(true);
    }

    /**
     * 删除租户套餐
     *
     * @param id description = "编号", required = true
     * @return
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:tenant-package:delete')")
    public CommonResult<Boolean> deleteTenantPackage(@RequestParam("id") Long id) {
        tenantPackageService.deleteTenantPackage(id);
        return success(true);
    }

    /**
     * 获得租户套餐
     * @param id  description = "编号", required = true, example = "1024"
     * @return
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:tenant-package:query')")
    public CommonResult<TenantPackageRespVO> getTenantPackage(@RequestParam("id") Long id) {
        TenantPackageDO tenantPackage = tenantPackageService.getTenantPackage(id);
        return success(TenantPackageConvert.INSTANCE.convert(tenantPackage));
    }

    /**
     * 获得租户套餐分页
     *
     * @param pageVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:tenant-package:query')")
    public CommonResult<PageResult<TenantPackageRespVO>> getTenantPackagePage(@Valid TenantPackagePageReqVO pageVO) {
        PageResult<TenantPackageDO> pageResult = tenantPackageService.getTenantPackagePage(pageVO);
        return success(TenantPackageConvert.INSTANCE.convertPage(pageResult));
    }

    /**
     * 获取租户套餐精简信息列表 description = "只包含被开启的租户套餐，主要用于前端的下拉选项"
     *
     * @return
     */
    @GetMapping("/get-simple-list")
    public CommonResult<List<TenantPackageSimpleRespVO>> getTenantPackageList() {
        // 获得角色列表，只要开启状态的
        List<TenantPackageDO> list = tenantPackageService.getTenantPackageListByStatus(CommonStatusEnum.ENABLE.getStatus());
        return success(TenantPackageConvert.INSTANCE.convertList02(list));
    }

}
