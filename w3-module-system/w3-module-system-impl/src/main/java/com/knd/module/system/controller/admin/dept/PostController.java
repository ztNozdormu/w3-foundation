package com.w3.module.system.controller.admin.dept;


import com.w3.framework.common.enums.CommonStatusEnum;
import com.w3.framework.common.pojo.CommonResult;
import com.w3.framework.common.pojo.PageResult;
import com.w3.framework.excel.core.util.ExcelUtils;
import com.w3.framework.operatelog.core.annotations.OperateLog;
import com.w3.module.system.controller.admin.dept.vo.post.*;
import com.w3.module.system.convert.dept.PostConvert;
import com.w3.module.system.dal.dataobject.dept.PostDO;
import com.w3.module.system.service.dept.PostService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.w3.framework.common.pojo.CommonResult.success;
import static com.w3.framework.operatelog.core.enums.OperateTypeEnum.EXPORT;


/**
 * 管理后台 - 岗位
 */
@RestController
@RequestMapping("/system/post")
@Validated
public class PostController {

    @Resource
    private PostService postService;

    /**
     * 创建岗位
     * @param reqVO
     * @return
     */
    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('system:post:create')")
    public CommonResult<Long> createPost(@Valid @RequestBody PostCreateReqVO reqVO) {
        Long postId = postService.createPost(reqVO);
        return success(postId);
    }

    /**
     * 修改岗位
     * @param reqVO
     * @return
     */
    @PutMapping("/update")
    @PreAuthorize("@ss.hasPermission('system:post:update')")
    public CommonResult<Boolean> updatePost(@Valid @RequestBody PostUpdateReqVO reqVO) {
        postService.updatePost(reqVO);
        return success(true);
    }

    /**
     * 删除岗位
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    @PreAuthorize("@ss.hasPermission('system:post:delete')")
    public CommonResult<Boolean> deletePost(@RequestParam("id") Long id) {
        postService.deletePost(id);
        return success(true);
    }

    /**
     * 获得岗位信息
     * @param id description = "岗位编号", required = true, example = "1024"
     * @return
     */
    @GetMapping(value = "/get")
    @PreAuthorize("@ss.hasPermission('system:post:query')")
    public CommonResult<PostRespVO> getPost(@RequestParam("id") Long id) {
        return success(PostConvert.INSTANCE.convert(postService.getPost(id)));
    }

    /**
     * 获取岗位精简信息列表 description = "只包含被开启的岗位，主要用于前端的下拉选项"
     * @return
     */
    @GetMapping("/list-all-simple")
    public CommonResult<List<PostSimpleRespVO>> getSimplePostList() {
        // 获得岗位列表，只要开启状态的
        List<PostDO> list = postService.getPostList(null, Collections.singleton(CommonStatusEnum.ENABLE.getStatus()));
        // 排序后，返回给前端
        list.sort(Comparator.comparing(PostDO::getSort));
        return success(PostConvert.INSTANCE.convertList02(list));
    }

    /**
     * 获得岗位分页列表
     * @param reqVO
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('system:post:query')")
    public CommonResult<PageResult<PostRespVO>> getPostPage(@Validated PostPageReqVO reqVO) {
        return success(PostConvert.INSTANCE.convertPage(postService.getPostPage(reqVO)));
    }

    /**
     * 岗位管理
     * @param response
     * @param reqVO
     * @throws IOException
     */
    @GetMapping("/export")
    @PreAuthorize("@ss.hasPermission('system:post:export')")
    @OperateLog(type = EXPORT)
    public void export(HttpServletResponse response, @Validated PostExportReqVO reqVO) throws IOException {
        List<PostDO> posts = postService.getPostList(reqVO);
        List<PostExcelVO> data = PostConvert.INSTANCE.convertList03(posts);
        // 输出
        ExcelUtils.write(response, "岗位数据.xls", "岗位列表", PostExcelVO.class, data);
    }

}
