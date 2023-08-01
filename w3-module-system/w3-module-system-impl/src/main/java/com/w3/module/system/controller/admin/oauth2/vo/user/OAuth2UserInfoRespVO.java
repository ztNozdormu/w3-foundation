package com.w3.module.system.controller.admin.oauth2.vo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * description = "管理后台 - OAuth2 获得用户基本信息 Response VO"
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OAuth2UserInfoRespVO {

    /**
     * description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
     */
    private Long id;

    /**
     * description = "用户账号", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿"
     */
    private String username;

    /**
     * description = "用户昵称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋道"
     */
    private String nickname;

    /**
     * description = "用户邮箱", example = "yudao@iocoder.cn"
     */
    private String email;
    /**
     * description = "手机号码", example = "15601691300"
     */
    private String mobile;

    /**
     * description = "用户性别,参见 SexEnum 枚举类", example = "1"
     */
    private Integer sex;

    /**
     * description = "用户头像", example = "https://www.iocoder.cn/xxx.png"
     */
    private String avatar;

    /**
     * 所在部门
     */
    private Dept dept;

    /**
     * 所属岗位数组
     */
    private List<Post> posts;

    /**
     * description = "部门"
     */
    @Data
    public static class Dept {

        /**
         * description = "部门编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
         */
        private Long id;

        /**
         * description = "部门名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "研发部"
         */
        private String name;

    }

    /**
     * description = "岗位"
     */
    @Data
    public static class Post {

        /**
         * description = "岗位编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
         */
        private Long id;

        /**
         * description = "岗位名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "开发"
         */
        private String name;

    }

}
