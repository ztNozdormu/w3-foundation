package com.w3.module.infra.controller.admin.file.vo.file;

import com.w3.framework.common.pojo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FilePageReqVO extends PageParam {

    private String path;

    private String type;

    private LocalDateTime[] createTime;

}
