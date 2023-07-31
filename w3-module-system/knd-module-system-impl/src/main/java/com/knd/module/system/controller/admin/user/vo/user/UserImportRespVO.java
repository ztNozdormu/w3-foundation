package com.knd.module.system.controller.admin.user.vo.user;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * description = "管理后台 - 用户导入 Response VO"
 */
@Data
@Builder
public class UserImportRespVO {

    /**
     * description = "创建成功的用户名数组", requiredMode = Schema.RequiredMode.REQUIRED
     */
    private List<String> createUsernames;

    /**
     * description = "更新成功的用户名数组", requiredMode = Schema.RequiredMode.REQUIRED
     */
    private List<String> updateUsernames;

    /**
     * description = "导入失败的用户集合,key 为用户名，value 为失败原因", requiredMode = Schema.RequiredMode.REQUIRED
     */
    private Map<String, String> failureUsernames;

}
