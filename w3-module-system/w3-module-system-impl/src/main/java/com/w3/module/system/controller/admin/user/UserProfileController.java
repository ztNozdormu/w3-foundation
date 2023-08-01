package com.w3.module.system.controller.admin.user;

import cn.hutool.core.collection.CollUtil;

import com.w3.framework.common.enums.UserTypeEnum;
import com.w3.framework.common.pojo.CommonResult;
import com.w3.framework.datapermission.core.annotation.DataPermission;
import com.w3.module.system.controller.admin.user.vo.profile.UserProfileRespVO;
import com.w3.module.system.controller.admin.user.vo.profile.UserProfileUpdatePasswordReqVO;
import com.w3.module.system.controller.admin.user.vo.profile.UserProfileUpdateReqVO;
import com.w3.module.system.convert.user.UserConvert;
import com.w3.module.system.dal.dataobject.dept.DeptDO;
import com.w3.module.system.dal.dataobject.dept.PostDO;
import com.w3.module.system.dal.dataobject.permission.RoleDO;
import com.w3.module.system.dal.dataobject.social.SocialUserDO;
import com.w3.module.system.dal.dataobject.user.AdminUserDO;
import com.w3.module.system.service.dept.DeptService;
import com.w3.module.system.service.dept.PostService;
import com.w3.module.system.service.permission.PermissionService;
import com.w3.module.system.service.permission.RoleService;
import com.w3.module.system.service.social.SocialUserService;
import com.w3.module.system.service.user.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static com.w3.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.w3.framework.common.pojo.CommonResult.success;
import static com.w3.framework.web.core.util.WebFrameworkUtils.getLoginUserId;
import static com.w3.module.infra.api.enums.ErrorCodeConstants.FILE_IS_EMPTY;


/**
 * 管理后台 - 用户个人中心
 */
@RestController
@RequestMapping("/system/user/profile")
@Validated
@Slf4j
public class UserProfileController {

    @Resource
    private AdminUserService userService;
    @Resource
    private DeptService deptService;
    @Resource
    private PostService postService;
    @Resource
    private PermissionService permissionService;
    @Resource
    private RoleService roleService;
    @Resource
    private SocialUserService socialService;

    /**
     * 获得登录用户信息
     * @return
     */
    @GetMapping("/get")
    @DataPermission(enable = false) // 关闭数据权限，避免只查看自己时，查询不到部门。
    public CommonResult<UserProfileRespVO> profile() {
        // 获得用户基本信息
        AdminUserDO user = userService.getUser(getLoginUserId());
        UserProfileRespVO resp = UserConvert.INSTANCE.convert03(user);
        // 获得用户角色
        List<RoleDO> userRoles = roleService.getRoleListFromCache(permissionService.getUserRoleIdListByUserId(user.getId()));
        resp.setRoles(UserConvert.INSTANCE.convertList(userRoles));
        // 获得部门信息
        if (user.getDeptId() != null) {
            DeptDO dept = deptService.getDept(user.getDeptId());
            resp.setDept(UserConvert.INSTANCE.convert02(dept));
        }
        // 获得岗位信息
        if (CollUtil.isNotEmpty(user.getPostIds())) {
            List<PostDO> posts = postService.getPostList(user.getPostIds());
            resp.setPosts(UserConvert.INSTANCE.convertList02(posts));
        }
        // 获得社交用户信息
        List<SocialUserDO> socialUsers = socialService.getSocialUserList(user.getId(), UserTypeEnum.ADMIN.getValue());
        resp.setSocialUsers(UserConvert.INSTANCE.convertList03(socialUsers));
        return success(resp);
    }

    /**
     * 修改用户个人信息
     * @param reqVO
     * @return
     */
    @PutMapping("/update")
    public CommonResult<Boolean> updateUserProfile(@Valid @RequestBody UserProfileUpdateReqVO reqVO) {
        userService.updateUserProfile(getLoginUserId(), reqVO);
        return success(true);
    }

    /**
     * 修改用户个人密码
     * @param reqVO
     * @return
     */
    @PutMapping("/update-password")
    public CommonResult<Boolean> updateUserProfilePassword(@Valid @RequestBody UserProfileUpdatePasswordReqVO reqVO) {
        userService.updateUserPassword(getLoginUserId(), reqVO);
        return success(true);
    }

    /**
     * 上传用户个人头像
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/update-avatar", method = {RequestMethod.POST, RequestMethod.PUT}) // 解决 uni-app 不支持 Put 上传文件的问题
    public CommonResult<String> updateUserAvatar(@RequestParam("avatarFile") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw exception(FILE_IS_EMPTY);
        }
        String avatar = userService.updateUserAvatar(getLoginUserId(), file.getInputStream());
        return success(avatar);
    }

}
