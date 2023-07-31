package com.w3.module.infra.controller.admin.file.vo.file;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 管理后台 - 文件 Response VO,不返回 content 字段，太大
 */
@Data
public class FileRespVO {

    /**
     * 文件编号 example = "1024"
     */
    private Long id;

    /**
     * 配置编号 example = "11"
     */
    private Long configId;

    /**
     * 文件路径 example = "knd.jpg"
     */
    private String path;

    /**
     * 原文件名 example = "knd.jpg"
     */
    private String name;

    /**
     * 文件 URL  example = "https://www.iocoder.cn/knd.jpg"
     */
    private String url;

    /**
     * 文件MIME类型 example = "application/octet-stream"
     */
    private String type;

    /**
     * 文件大小 example = "2048"
     */
    private Integer size;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
