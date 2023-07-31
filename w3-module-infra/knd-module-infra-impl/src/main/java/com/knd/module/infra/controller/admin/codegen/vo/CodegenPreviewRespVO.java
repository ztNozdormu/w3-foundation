package com.knd.module.infra.controller.admin.codegen.vo;

import lombok.Data;

/**
 * 管理后台 - 代码生成预览 Response VO,注意，每个文件都是一个该对象
 */
@Data
public class CodegenPreviewRespVO {

    /**
     * 文件路径 example = "java/cn/iocoder/yudao/adminserver/modules/system/controller/test/SysTestDemoController.java"
     */
    private String filePath;

    /**
     * 代码 example = "Hello World"
     */
    private String code;

}
