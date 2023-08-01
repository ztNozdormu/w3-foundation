package com.w3.module.infra.convert.file;


import com.w3.framework.common.pojo.PageResult;
import com.w3.module.infra.api.dal.dataobject.file.FileDO;
import com.w3.module.infra.controller.admin.file.vo.file.FileRespVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileConvert {

    FileConvert INSTANCE = Mappers.getMapper(FileConvert.class);

    FileRespVO convert(FileDO bean);

    PageResult<FileRespVO> convertPage(PageResult<FileDO> page);

}
