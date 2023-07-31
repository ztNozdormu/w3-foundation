package com.knd.module.system.single.controller.admin.permission;


import com.knd.framework.common.enums.CommonStatusEnum;
import com.knd.framework.common.pojo.CommonResult;
import com.knd.framework.common.pojo.PageResult;
import com.knd.framework.excel.core.util.ExcelUtils;
import com.knd.framework.operatelog.core.annotations.OperateLog;
import com.knd.module.system.convert.permission.RoleConvert;
import com.knd.module.system.dal.dataobject.permission.RoleDO;
import com.knd.module.system.service.permission.RoleService;
import com.knd.module.system.single.admin.permission.vo.role.*;
import com.knd.module.system.single.controller.admin.permission.vo.role.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import static com.knd.framework.common.pojo.CommonResult.success;
import static com.knd.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;
import static java.util.Collections.singleton;

/**
 * 管理后台 - 角色
 */
@RestController
@RequestMapping("/system/role")
@Validated
public class RoleController {

    @Resource
    private RoleService roleService;

    /**
     * 创建角色
     * @param reqVO
     * @return
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:role:create')")
    public CommonResult<Long> createRole(@Valid @RequestBody RoleCreateReqVO reqVO) {
        return success(roleService.createRole(reqVO, null));
    }

    /**
     * 修改角色
     * @param reqVO
     * @return
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:role:update')")
    public CommonResult<Boolean> updateRole(@Valid @RequestBody RoleUpdateReqVO reqVO) {
        roleService.updateRole(reqVO);
        return success(true);
    }

    /**
     * 修改角色状态
     * @param reqVO
     * @return
     */
    @PutMapping("/update-status")
    @PreAuthorize("@ss.hasPermission('system:role:update')")
    public CommonResult<Boolean> updateRoleStatus(@Valid @RequestBody RoleUpdateStatusReqVO reqVO) {
        roleService.updateRoleStatus(reqVO.getId(), reqVO.getStatus());
        return success(true);
    }

    /**
     * 删除角色
     * @param id  description = "角色编号", required = true, example = "1024"
     * @return
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:role:delete')")
    public CommonResult<Boolean> deleteRole(@RequestParam("id") Long id) {
        roleService.deleteRole(id);
        return success(true);
    }

    /**
     * 获得角色信息
     * @param id
     * @return
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:role:query')")
    public CommonResult<RoleRespVO> getRole(@RequestParam("id") Long id) {
        RoleDO role = roleService.getRole(id);
        return success(RoleConvert.INSTANCE.convert(role));
    }

    /**
     * 获得角色分页
     * @param reqVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:role:query')")
    public CommonResult<PageResult<RoleDO>> getRolePage(RolePageReqVO reqVO) {
        return success(roleService.getRolePage(reqVO));
    }

    /**
     * 获取角色精简信息列表 description = "只包含被开启的角色，主要用于前端的下拉选项"
     * @return
     */
    @GetMapping("/list-all-simple")
    public CommonResult<List<RoleSimpleRespVO>> getSimpleRoleList() {
        // 获得角色列表，只要开启状态的
        List<RoleDO> list = roleService.getRoleListByStatus(singleton(CommonStatusEnum.ENABLE.getStatus()));
        // 排序后，返回给前端
        list.sort(Comparator.comparing(RoleDO::getSort));
        return success(RoleConvert.INSTANCE.convertList02(list));
    }

    /**
     * export
     * @param response
     * @param reqVO
     * @throws IOException
     */
    @GetMapping("/export")
    @OperateLog(type = EXPORT)
    @PreAuthorize("@ss.hasPermission('system:role:export')")
    public void export(HttpServletResponse response, @Validated RoleExportReqVO reqVO) throws IOException {
        List<RoleDO> list = roleService.getRoleList(reqVO);
        List<RoleExcelVO> data = RoleConvert.INSTANCE.convertList03(list);
        // 输出
        ExcelUtils.write(response, "角色数据.xls", "角色列表", RoleExcelVO.class, data);
    }

}
