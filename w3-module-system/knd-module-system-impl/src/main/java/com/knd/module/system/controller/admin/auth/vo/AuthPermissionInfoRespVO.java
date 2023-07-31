package com.knd.module.system.controller.admin.auth.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * 管理后台 - 登录用户的权限信息 Response VO,额外包括用户信息和角色列表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthPermissionInfoRespVO {

    /**
     * 用户信息
     */
    private UserVO user;

    /**
     * 角色标识数组
     */
    private Set<String> roles;

    /**
     * 操作权限数组
     */
    private Set<String> permissions;

    /**
     * 用户信息 VO
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UserVO {

        /**
         * 用户编号 example = "1024"
         */
        private Long id;

        /**
         * 用户昵称 example = "芋道源码"
         */
        private String nickname;

        /**
         * 用户头像 example = "http://www.iocoder.cn/xx.jpg"
         */
        private String avatar;

    }

}
