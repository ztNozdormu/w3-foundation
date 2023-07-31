package com.knd.module.infra.single.dal.mysql.file;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.knd.module.infra.api.dal.dataobject.file.FileContentDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileContentMapper extends BaseMapper<FileContentDO> {
}
