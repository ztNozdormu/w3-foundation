package com.w3.module.infra.controller.admin.file;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import com.w3.framework.common.pojo.CommonResult;
import com.w3.framework.common.pojo.PageResult;
import com.w3.framework.common.util.servlet.ServletUtils;
import com.w3.framework.operatelog.core.annotations.OperateLog;
import com.w3.module.infra.api.dal.dataobject.file.FileDO;
import com.w3.module.infra.controller.admin.file.vo.file.FilePageReqVO;
import com.w3.module.infra.controller.admin.file.vo.file.FileRespVO;
import com.w3.module.infra.controller.admin.file.vo.file.FileUploadReqVO;
import com.w3.module.infra.convert.file.FileConvert;
import com.w3.module.infra.service.file.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import static com.w3.framework.common.pojo.CommonResult.success;


/**
 * 管理后台 - 文件存储
 */
@RestController
@RequestMapping("/infra/file")
@Validated
@Slf4j
public class FileController {

    @Resource
    private FileService fileService;

    /**
     * 上传文件
     * @param uploadReqVO
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")
    @OperateLog(logArgs = false) // 上传文件，没有记录操作日志的必要
    public CommonResult<String> uploadFile(FileUploadReqVO uploadReqVO) throws Exception {
        MultipartFile file = uploadReqVO.getFile();
        String path = uploadReqVO.getPath();
        return success(fileService.createFile(file.getOriginalFilename(), path, IoUtil.readBytes(file.getInputStream())));
    }

    /**
     * 删除文件
     * @param id description = "编号", required = true
     * @return
     * @throws Exception
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('infra:file:delete')")
    public CommonResult<Boolean> deleteFile(@RequestParam("id") Long id) throws Exception {
        fileService.deleteFile(id);
        return success(true);
    }

    /***
     * 下载文件
     * @param request
     * @param response
     * @param configId  description = "配置编号",  required = true
     * @throws Exception
     */
    @GetMapping("/{configId}/get/**")
    @PermitAll
    public void getFileContent(HttpServletRequest request,
                               HttpServletResponse response,
                               @PathVariable("configId") Long configId) throws Exception {
        // 获取请求的路径
        String path = StrUtil.subAfter(request.getRequestURI(), "/get/", false);
        if (StrUtil.isEmpty(path)) {
            throw new IllegalArgumentException("结尾的 path 路径必须传递");
        }

        // 读取内容
        byte[] content = fileService.getFileContent(configId, path);
        if (content == null) {
            log.warn("[getFileContent][configId({}) path({}) 文件不存在]", configId, path);
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return;
        }
        ServletUtils.writeAttachment(response, path, content);
    }

    /**
     * 获得文件分页
     * @param pageVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('infra:file:query')")
    public CommonResult<PageResult<FileRespVO>> getFilePage(@Valid FilePageReqVO pageVO) {
        PageResult<FileDO> pageResult = fileService.getFilePage(pageVO);
        return success(FileConvert.INSTANCE.convertPage(pageResult));
    }

}
