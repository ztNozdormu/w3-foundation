package com.w3.module.system.controller.admin.user.vo.profile;

import com.w3.module.system.controller.admin.user.vo.user.UserBaseVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 管理后台 - 用户个人中心信息 Response VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileRespVO extends UserBaseVO {

    /**
     * description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
     */
    private Long id;

    /**
     * description = "状态,参见 CommonStatusEnum 枚举类", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
     */
    private Integer status;

    /**
     * description ="最后登录 IP",requiredMode =Schema.RequiredMode.REQUIRED,example ="192.168.1.1"
     */

    private String loginIp;

    /**
     * description ="最后登录时间",requiredMode =Schema.RequiredMode.REQUIRED,example ="时间戳格式"
     */

    private LocalDateTime loginDate;

    /**
     * description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "时间戳格式"
     */
    private LocalDateTime createTime;

    /**
     * 所属角色
     */
    private List<Role> roles;

    /**
     * 所在部门
     */
    private Dept dept;

    /**
     * 所属岗位数组
     */
    private List<Post> posts;
    /**
     * 社交用户数组
     */
    private List<SocialUser> socialUsers;

    /**
     * description ="角色"
     */


    @Data
    public static class Role {

        /**
         * description = "角色编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1"
         */
        private Long id;

        /**
         * description = "角色名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "普通角色"
         */
        private String name;

    }

    /**
     * description ="部门"
     */


    @Data
    public static class Dept {

        /**
         * description ="部门编号",requiredMode =Schema.RequiredMode.REQUIRED,example ="1"
         */

        private Long id;

        /**
         * description ="部门名称",requiredMode =Schema.RequiredMode.REQUIRED,example ="研发部"
         */

        private String name;

    }

    /**
     * description ="岗位"
     */


    @Data
    public static class Post {

        /**
         * description ="岗位编号",requiredMode =Schema.RequiredMode.REQUIRED,example ="1"
         */

        private Long id;

        /**
         * description ="岗位名称",requiredMode =Schema.RequiredMode.REQUIRED,example ="开发"
         */

        private String name;

    }

    /**
     * description = "社交用户"
     */
    @Data
    public static class SocialUser {

        /**
         * description = "社交平台的类型,参见 SocialTypeEnum 枚举类", requiredMode = Schema.RequiredMode.REQUIRED, example = "10"
         */
        private Integer type;

        /**
         * description = "社交用户的 openid", requiredMode = Schema.RequiredMode.REQUIRED, example = "IPRmJ0wvBptiPIlGEZiPewGwiEiE"
         */
        private String openid;

    }

}
