package com.w3.module.system.convert.mail;

import com.w3.framework.common.pojo.PageResult;
import com.w3.module.system.controller.admin.mail.vo.log.MailLogRespVO;
import com.w3.module.system.dal.dataobject.mail.MailLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MailLogConvert {

    MailLogConvert INSTANCE = Mappers.getMapper(MailLogConvert.class);

    PageResult<MailLogRespVO> convertPage(PageResult<MailLogDO> pageResult);

    MailLogRespVO convert(MailLogDO bean);

}
