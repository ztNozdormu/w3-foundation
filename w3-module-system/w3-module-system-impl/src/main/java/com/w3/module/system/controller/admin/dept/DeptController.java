package com.w3.module.system.controller.admin.dept;


import com.w3.framework.common.enums.CommonStatusEnum;
import com.w3.framework.common.pojo.CommonResult;
import com.w3.module.system.controller.admin.dept.vo.dept.*;
import com.w3.module.system.convert.dept.DeptConvert;
import com.w3.module.system.dal.dataobject.dept.DeptDO;
import com.w3.module.system.service.dept.DeptService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;

import static com.w3.framework.common.pojo.CommonResult.success;


/**
 * 管理后台 - 部门
 */
@RestController
@RequestMapping("/system/dept")
@Validated
public class DeptController {

    @Resource
    private DeptService deptService;

    /**
     * 创建部门
     * @param reqVO
     * @return
     */
    @PostMapping("create")
    @PreAuthorize("@ss.hasPermission('system:dept:create')")
    public CommonResult<Long> createDept(@Valid @RequestBody DeptCreateReqVO reqVO) {
        Long deptId = deptService.createDept(reqVO);
        return success(deptId);
    }

    /**
     * 更新部门
     * @param reqVO
     * @return
     */
    @PutMapping("update")
    @PreAuthorize("@ss.hasPermission('system:dept:update')")
    public CommonResult<Boolean> updateDept(@Valid @RequestBody DeptUpdateReqVO reqVO) {
        deptService.updateDept(reqVO);
        return success(true);
    }

    /**
     * 删除部门
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @DeleteMapping("delete")
    @PreAuthorize("@ss.hasPermission('system:dept:delete')")
    public CommonResult<Boolean> deleteDept(@RequestParam("id") Long id) {
        deptService.deleteDept(id);
        return success(true);
    }

    /**
     * 获取部门列表
     * @param reqVO
     * @return
     */
    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermission('system:dept:query')")
    public CommonResult<List<DeptRespVO>> getDeptList(DeptListReqVO reqVO) {
        List<DeptDO> list = deptService.getDeptList(reqVO);
        list.sort(Comparator.comparing(DeptDO::getSort));
        return success(DeptConvert.INSTANCE.convertList(list));
    }

    /**
     * 获取部门精简信息列表  description = "只包含被开启的部门，主要用于前端的下拉选项"
     * @return
     */
    @GetMapping("/list-all-simple")
    public CommonResult<List<DeptSimpleRespVO>> getSimpleDeptList() {
        // 获得部门列表，只要开启状态的
        DeptListReqVO reqVO = new DeptListReqVO();
        reqVO.setStatus(CommonStatusEnum.ENABLE.getStatus());
        List<DeptDO> list = deptService.getDeptList(reqVO);
        // 排序后，返回给前端
        list.sort(Comparator.comparing(DeptDO::getSort));
        return success(DeptConvert.INSTANCE.convertList02(list));
    }

    /**
     * 获得部门信息
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:dept:query')")
    public CommonResult<DeptRespVO> getDept(@RequestParam("id") Long id) {
        return success(DeptConvert.INSTANCE.convert(deptService.getDept(id)));
    }

}
