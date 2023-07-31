package com.knd.module.system.controller.admin.user.vo.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * description = "管理后台 - 用户分页时的信息 Response VO,相比用户基本信息来说，会多部门信息"
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserPageItemRespVO extends UserRespVO {

    /**
     * 所在部门
     */
    private Dept dept;

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

}
