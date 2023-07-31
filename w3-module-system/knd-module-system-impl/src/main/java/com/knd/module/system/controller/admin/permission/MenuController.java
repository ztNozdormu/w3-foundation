package com.knd.module.system.controller.admin.permission;


import com.knd.framework.common.enums.CommonStatusEnum;
import com.knd.framework.common.pojo.CommonResult;
import com.knd.module.system.controller.admin.permission.vo.menu.*;
import com.knd.module.system.convert.permission.MenuConvert;
import com.knd.module.system.dal.dataobject.permission.MenuDO;
import com.knd.module.system.service.permission.MenuService;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;

import static com.knd.framework.common.pojo.CommonResult.success;


/**
 * 管理后台 - 菜单
 */
@RestController
@RequestMapping("/system/menu")
@Validated
public class MenuController {

    @Resource
    private MenuService menuService;

    /**
     * 创建菜单
     * @param reqVO
     * @return
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:menu:create')")
    public CommonResult<Long> createMenu(@Valid @RequestBody MenuCreateReqVO reqVO) {
        Long menuId = menuService.createMenu(reqVO);
        return success(menuId);
    }

    /**
     * 修改菜单
     * @param reqVO
     * @return
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:menu:update')")
    public CommonResult<Boolean> updateMenu(@Valid @RequestBody MenuUpdateReqVO reqVO) {
        menuService.updateMenu(reqVO);
        return success(true);
    }

    /**
     * 删除菜单
     * @param id description = "角色编号", required= true, example = "1024"
     * @return
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:menu:delete')")
    public CommonResult<Boolean> deleteMenu(@RequestParam("id") Long id) {
        menuService.deleteMenu(id);
        return success(true);
    }

    /**
     * 获取菜单列表
     * @param reqVO
     * @return
     */
    @GetMapping("/list")
    @PreAuthorize("@ss.hasPermission('system:menu:query')")
    public CommonResult<List<MenuRespVO>> getMenuList(MenuListReqVO reqVO) {
        List<MenuDO> list = menuService.getMenuList(reqVO);
        list.sort(Comparator.comparing(MenuDO::getSort));
        return success(MenuConvert.INSTANCE.convertList(list));
    }

    /**
     * 获取菜单精简信息列表 description = "只包含被开启的菜单，用于【角色分配菜单】功能的选项。" +
     *             "在多租户的场景下，会只返回租户所在套餐有的菜单"
     * @return
     */
    @GetMapping("/list-all-simple")
    public CommonResult<List<MenuSimpleRespVO>> getSimpleMenuList() {
        // 获得菜单列表，只要开启状态的
        MenuListReqVO reqVO = new MenuListReqVO();
        reqVO.setStatus(CommonStatusEnum.ENABLE.getStatus());
        List<MenuDO> list = menuService.getMenuListByTenant(reqVO);
        // 排序后，返回给前端
        list.sort(Comparator.comparing(MenuDO::getSort));
        return success(MenuConvert.INSTANCE.convertList02(list));
    }

    /**
     * 获取菜单信息
     * @param id
     * @return
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:menu:query')")
    public CommonResult<MenuRespVO> getMenu(Long id) {
        MenuDO menu = menuService.getMenu(id);
        return success(MenuConvert.INSTANCE.convert(menu));
    }

}
