package com.knd.module.system.convert.mail;

import com.knd.framework.common.pojo.PageResult;
import com.knd.module.system.controller.admin.mail.vo.template.MailTemplateCreateReqVO;
import com.knd.module.system.controller.admin.mail.vo.template.MailTemplateRespVO;
import com.knd.module.system.controller.admin.mail.vo.template.MailTemplateSimpleRespVO;
import com.knd.module.system.controller.admin.mail.vo.template.MailTemplateUpdateReqVO;
import com.knd.module.system.dal.dataobject.mail.MailTemplateDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MailTemplateConvert {

    MailTemplateConvert INSTANCE = Mappers.getMapper(MailTemplateConvert.class);

    MailTemplateDO convert(MailTemplateUpdateReqVO bean);

    MailTemplateDO convert(MailTemplateCreateReqVO bean);

    MailTemplateRespVO convert(MailTemplateDO bean);

    PageResult<MailTemplateRespVO> convertPage(PageResult<MailTemplateDO> pageResult);

    List<MailTemplateSimpleRespVO> convertList02(List<MailTemplateDO> list);

}
