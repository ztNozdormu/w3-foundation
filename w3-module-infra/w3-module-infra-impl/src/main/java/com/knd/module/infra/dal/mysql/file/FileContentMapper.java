package com.w3.module.infra.dal.mysql.file;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.w3.module.infra.api.dal.dataobject.file.FileContentDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileContentMapper extends BaseMapper<FileContentDO> {
}
