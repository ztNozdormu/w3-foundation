package com.knd.module.infra.single.convert.file;


import com.knd.framework.common.pojo.PageResult;
import com.knd.module.infra.api.dal.dataobject.file.FileDO;
import com.knd.module.infra.single.controller.admin.file.vo.file.FileRespVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileConvert {

    FileConvert INSTANCE = Mappers.getMapper(FileConvert.class);

    FileRespVO convert(FileDO bean);

    PageResult<FileRespVO> convertPage(PageResult<FileDO> page);

}
