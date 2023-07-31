package com.knd.module.system.convert.notify;


import com.knd.framework.common.pojo.PageResult;
import com.knd.module.system.controller.admin.notify.vo.template.NotifyTemplateCreateReqVO;
import com.knd.module.system.controller.admin.notify.vo.template.NotifyTemplateRespVO;
import com.knd.module.system.controller.admin.notify.vo.template.NotifyTemplateUpdateReqVO;
import com.knd.module.system.dal.dataobject.notify.NotifyTemplateDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 站内信模版 Convert
 *
 * @author xrcoder
 */
@Mapper
public interface NotifyTemplateConvert {

    NotifyTemplateConvert INSTANCE = Mappers.getMapper(NotifyTemplateConvert.class);

    NotifyTemplateDO convert(NotifyTemplateCreateReqVO bean);

    NotifyTemplateDO convert(NotifyTemplateUpdateReqVO bean);

    NotifyTemplateRespVO convert(NotifyTemplateDO bean);

    List<NotifyTemplateRespVO> convertList(List<NotifyTemplateDO> list);

    PageResult<NotifyTemplateRespVO> convertPage(PageResult<NotifyTemplateDO> page);

}
