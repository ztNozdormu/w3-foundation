package com.knd.module.system.controller.admin.ip.vo;

import lombok.Data;

import java.util.List;

/**
 * description = "管理后台 - 地区节点 Response VO"
 */
@Data
public class AreaNodeRespVO {

    /**
     * description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "110000"
     */
    private Integer id;

    /**
     * description = "名字", requiredMode = Schema.RequiredMode.REQUIRED, example = "北京"
     */
    private String name;

    /**
     * 子节点
     */
    private List<AreaNodeRespVO> children;

}
