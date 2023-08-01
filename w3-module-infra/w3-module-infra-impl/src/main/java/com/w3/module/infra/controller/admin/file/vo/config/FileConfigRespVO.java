package com.w3.module.infra.controller.admin.file.vo.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * 管理后台 - 文件配置 Response VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FileConfigRespVO extends FileConfigBaseVO {

    /**
     * 编号 example = "1"
     */
    private Long id;

    /**
     * 存储器,参见 FileStorageEnum 枚举类 example = "1"
     */
    @NotNull(message = "存储器不能为空")
    private Integer storage;

    /**
     * 是否为主配置 example = "true"
     */
    @NotNull(message = "是否为主配置不能为空")
    private Boolean master;

    /**
     * 存储配置 TODO 暂时注释
     */
//    private FileClientConfig config;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
