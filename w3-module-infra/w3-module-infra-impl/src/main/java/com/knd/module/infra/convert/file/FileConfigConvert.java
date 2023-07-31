package com.w3.module.infra.convert.file;


import com.w3.framework.common.pojo.PageResult;
import com.w3.module.infra.api.dal.dataobject.file.FileConfigDO;
import com.w3.module.infra.controller.admin.file.vo.config.FileConfigCreateReqVO;
import com.w3.module.infra.controller.admin.file.vo.config.FileConfigRespVO;
import com.w3.module.infra.controller.admin.file.vo.config.FileConfigUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 文件配置 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface FileConfigConvert {

    FileConfigConvert INSTANCE = Mappers.getMapper(FileConfigConvert.class);

    @Mapping(target = "config", ignore = true)
    FileConfigDO convert(FileConfigCreateReqVO bean);

    @Mapping(target = "config", ignore = true)
    FileConfigDO convert(FileConfigUpdateReqVO bean);

    FileConfigRespVO convert(FileConfigDO bean);

    List<FileConfigRespVO> convertList(List<FileConfigDO> list);

    PageResult<FileConfigRespVO> convertPage(PageResult<FileConfigDO> page);

}
