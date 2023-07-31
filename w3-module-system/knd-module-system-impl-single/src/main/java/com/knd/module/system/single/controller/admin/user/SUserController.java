package com.knd.module.system.single.controller.admin.user;

import cn.hutool.core.collection.CollUtil;
import com.knd.framework.common.enums.CommonStatusEnum;
import com.knd.framework.common.pojo.CommonResult;
import com.knd.framework.common.pojo.PageResult;
import com.knd.framework.common.util.collection.MapUtils;
import com.knd.framework.excel.core.util.ExcelUtils;
import com.knd.framework.operatelog.core.annotations.OperateLog;
import com.knd.module.system.controller.admin.user.vo.user.UserCreateReqVO;
import com.knd.module.system.controller.admin.user.vo.user.UserUpdatePasswordReqVO;
import com.knd.module.system.controller.admin.user.vo.user.UserUpdateReqVO;
import com.knd.module.system.controller.admin.user.vo.user.UserUpdateStatusReqVO;
import com.knd.module.system.convert.user.UserConvert;
import com.knd.module.system.dal.dataobject.dept.DeptDO;
import com.knd.module.system.dal.dataobject.user.AdminUserDO;
import com.knd.module.system.enums.common.SexEnum;
import com.knd.module.system.service.dept.DeptService;
import com.knd.module.system.service.user.AdminUserService;
import com.knd.module.system.single.controller.admin.user.vo.user.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

import static com.knd.framework.common.pojo.CommonResult.success;
import static com.knd.framework.common.util.collection.CollectionUtils.convertList;
import static com.knd.framework.common.util.collection.CollectionUtils.convertSet;
import static com.knd.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;


/**
 * 管理后台 - 用户
 */
@Controller
@RequestMapping("/system/user")
@Validated
public class SUserController {

    @Resource
    private AdminUserService userService;
    @Resource
    private DeptService deptService;

    /**
     * 新增用户
     * @param reqVO
     * @return
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:user:create')")
    public CommonResult<Long> createUser(@Valid @RequestBody UserCreateReqVO reqVO) {
        Long id = userService.createUser(reqVO);
        return success(id);
    }

    /**
     * 修改用户
     * @param reqVO
     * @return
     */
    @PutMapping("update")
    @PreAuthorize("@ss.hasPermission('system:user:update')")
    public CommonResult<Boolean> updateUser(@Valid @RequestBody UserUpdateReqVO reqVO) {
        userService.updateUser(reqVO);
        return success(true);
    }

    /**
     * 删除用户
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:user:delete')")
    public CommonResult<Boolean> deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return success(true);
    }

    /**
     * 重置用户密码
     * @param reqVO
     * @return
     */
    @PutMapping("/update-password")
    @PreAuthorize("@ss.hasPermission('system:user:update-password')")
    public CommonResult<Boolean> updateUserPassword(@Valid @RequestBody UserUpdatePasswordReqVO reqVO) {
        userService.updateUserPassword(reqVO.getId(), reqVO.getPassword());
        return success(true);
    }

    /**
     * 修改用户状态
     * @param reqVO
     * @return
     */
    @PutMapping("/update-status")
    @PreAuthorize("@ss.hasPermission('system:user:update')")
    public CommonResult<Boolean> updateUserStatus(@Valid @RequestBody UserUpdateStatusReqVO reqVO) {
        userService.updateUserStatus(reqVO.getId(), reqVO.getStatus());
        return success(true);
    }

    /**
     * 获得用户分页列表
     * @param reqVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:user:list')")
    public CommonResult<PageResult<UserPageItemRespVO>> getUserPage(@Valid UserPageReqVO reqVO) {
        // 获得用户分页列表
        PageResult<AdminUserDO> pageResult = userService.getUserPage(reqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(new PageResult<>(pageResult.getTotal())); // 返回空
        }

        // 获得拼接需要的数据
        Collection<Long> deptIds = convertList(pageResult.getList(), AdminUserDO::getDeptId);
        Map<Long, DeptDO> deptMap = deptService.getDeptMap(deptIds);
        // 拼接结果返回
        List<UserPageItemRespVO> userList = new ArrayList<>(pageResult.getList().size());
        pageResult.getList().forEach(user -> {
            UserPageItemRespVO respVO = UserConvert.INSTANCE.convert(user);
            respVO.setDept(UserConvert.INSTANCE.convert(deptMap.get(user.getDeptId())));
            userList.add(respVO);
        });
        return success(new PageResult<>(userList, pageResult.getTotal()));
    }

    /**
     * 获取用户精简信息列表 description = "只包含被开启的用户，主要用于前端的下拉选项"
     * @return
     */
    @GetMapping("/list-all-simple")
    public CommonResult<List<UserSimpleRespVO>> getSimpleUserList() {
        // 获用户列表，只要开启状态的
        List<AdminUserDO> list = userService.getUserListByStatus(CommonStatusEnum.ENABLE.getStatus());
        // 排序后，返回给前端
        return success(UserConvert.INSTANCE.convertList04(list));
    }

    /**
     * 获得用户详情
     * @param id description = "编号", required = true, example = "1024"
     * @return
     */
    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('system:user:query')")
    public CommonResult<UserRespVO> getUser(@RequestParam("id") Long id) {
        AdminUserDO user = userService.getUser(id);
        // 获得部门数据
        DeptDO dept = deptService.getDept(user.getDeptId());
        return success(UserConvert.INSTANCE.convert(user).setDept(UserConvert.INSTANCE.convert(dept)));
    }

    /**
     * 导出用户
     * @param reqVO
     * @param response
     * @throws IOException
     */
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPermission('system:user:export')")
    @OperateLog(type = EXPORT)
    public void exportUserList(@Validated UserExportReqVO reqVO,
                               HttpServletResponse response) throws IOException {
        // 获得用户列表
        List<AdminUserDO> users = userService.getUserList(reqVO);

        // 获得拼接需要的数据
        Collection<Long> deptIds = convertList(users, AdminUserDO::getDeptId);
        Map<Long, DeptDO> deptMap = deptService.getDeptMap(deptIds);
        Map<Long, AdminUserDO> deptLeaderUserMap = userService.getUserMap(
                convertSet(deptMap.values(), DeptDO::getLeaderUserId));
        // 拼接数据
        List<UserExcelVO> excelUsers = new ArrayList<>(users.size());
        users.forEach(user -> {
            UserExcelVO excelVO = UserConvert.INSTANCE.convert02(user);
            // 设置部门
            MapUtils.findAndThen(deptMap, user.getDeptId(), dept -> {
                excelVO.setDeptName(dept.getName());
                // 设置部门负责人的名字
                MapUtils.findAndThen(deptLeaderUserMap, dept.getLeaderUserId(),
                        deptLeaderUser -> excelVO.setDeptLeaderNickname(deptLeaderUser.getNickname()));
            });
            excelUsers.add(excelVO);
        });

        // 输出
        ExcelUtils.write(response, "用户数据.xls", "用户列表", UserExcelVO.class, excelUsers);
    }

    /**
     * 获得导入用户模板
     * @param response
     * @throws IOException
     */
    @GetMapping("/get-import-template")
    public void importTemplate(HttpServletResponse response) throws IOException {
        // 手动创建导出 demo
        List<UserImportExcelVO> list = Arrays.asList(
                UserImportExcelVO.builder().username("yunai").deptId(1L).email("yunai@iocoder.cn").mobile("15601691300")
                        .nickname("芋道").status(CommonStatusEnum.ENABLE.getStatus()).sex(SexEnum.MALE.getSex()).build(),
                UserImportExcelVO.builder().username("yuanma").deptId(2L).email("yuanma@iocoder.cn").mobile("15601701300")
                        .nickname("源码").status(CommonStatusEnum.DISABLE.getStatus()).sex(SexEnum.FEMALE.getSex()).build()
        );

        // 输出
        ExcelUtils.write(response, "用户导入模板.xls", "用户列表", UserImportExcelVO.class, list);
    }

    /**
     * 导入用户
     * @param file description = "Excel 文件", required = true
     * @param updateSupport description = "是否支持更新，默认为 false", example = "true"
     * @return
     * @throws Exception
     */
    @PostMapping("/import")
    @PreAuthorize("@ss.hasPermission('system:user:import')")
    public CommonResult<UserImportRespVO> importExcel(@RequestParam("file") MultipartFile file,
                                                      @RequestParam(value = "updateSupport", required = false, defaultValue = "false") Boolean updateSupport) throws Exception {
        List<UserImportExcelVO> list = ExcelUtils.read(file, UserImportExcelVO.class);
        return success(userService.importUserList(list, updateSupport));
    }

}
