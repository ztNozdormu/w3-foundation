package com.knd.module.infra.dal.mysql.db;

import com.knd.framework.codegen.domain.db.DataSourceConfigDO;
import com.knd.framework.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据源配置 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DataSourceConfigMapper extends BaseMapperX<DataSourceConfigDO> {
}
