package com.knd.module.infra.single.controller.admin.file.vo.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * 管理后台 - 文件配置创建 Request VO
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FileConfigCreateReqVO extends FileConfigBaseVO {

    /**
     * 存储器,参见 FileStorageEnum 枚举类参见 FileStorageEnum 枚举类  example = "1"
     */
    @NotNull(message = "存储器不能为空")
    private Integer storage;

    /**
     * 存储配置,配置是动态参数，所以使用 Map 接收
     */
    @NotNull(message = "存储配置不能为空")
    private Map<String, Object> config;

}
