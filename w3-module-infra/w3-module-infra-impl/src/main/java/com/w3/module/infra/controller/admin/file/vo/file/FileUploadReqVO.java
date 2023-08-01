package com.w3.module.infra.controller.admin.file.vo.file;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * 管理后台 - 上传文件 Request VO
 */
@Data
public class FileUploadReqVO {

    /**
     * 文件附件
     */
    @NotNull(message = "文件附件不能为空")
    private MultipartFile file;

    /**
     * 文件附件路径  example = "yudaoyuanma.png"
     */
    private String path;

}
