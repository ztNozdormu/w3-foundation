package com.knd.module.system.convert.sensitiveword;


import com.knd.framework.common.pojo.PageResult;
import com.knd.module.system.controller.admin.sensitiveword.vo.SensitiveWordCreateReqVO;
import com.knd.module.system.controller.admin.sensitiveword.vo.SensitiveWordExcelVO;
import com.knd.module.system.controller.admin.sensitiveword.vo.SensitiveWordRespVO;
import com.knd.module.system.controller.admin.sensitiveword.vo.SensitiveWordUpdateReqVO;
import com.knd.module.system.dal.dataobject.sensitiveword.SensitiveWordDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 敏感词 Convert
 *
 * @author 永不言败
 */
@Mapper
public interface SensitiveWordConvert {

    SensitiveWordConvert INSTANCE = Mappers.getMapper(SensitiveWordConvert.class);

    SensitiveWordDO convert(SensitiveWordCreateReqVO bean);

    SensitiveWordDO convert(SensitiveWordUpdateReqVO bean);

    SensitiveWordRespVO convert(SensitiveWordDO bean);

    List<SensitiveWordRespVO> convertList(List<SensitiveWordDO> list);

    PageResult<SensitiveWordRespVO> convertPage(PageResult<SensitiveWordDO> page);

    List<SensitiveWordExcelVO> convertList02(List<SensitiveWordDO> list);

}
