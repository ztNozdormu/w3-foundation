package com.w3.module.infra.convert.db;

import com.w3.framework.codegen.domain.db.DataSourceConfigDO;
import com.w3.module.infra.controller.admin.db.vo.DataSourceConfigCreateReqVO;
import com.w3.module.infra.controller.admin.db.vo.DataSourceConfigRespVO;
import com.w3.module.infra.controller.admin.db.vo.DataSourceConfigUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 数据源配置 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface DataSourceConfigConvert {

    DataSourceConfigConvert INSTANCE = Mappers.getMapper(DataSourceConfigConvert.class);

    DataSourceConfigDO convert(DataSourceConfigCreateReqVO bean);

    DataSourceConfigDO convert(DataSourceConfigUpdateReqVO bean);

    DataSourceConfigRespVO convert(DataSourceConfigDO bean);

    List<DataSourceConfigRespVO> convertList(List<DataSourceConfigDO> list);

}
