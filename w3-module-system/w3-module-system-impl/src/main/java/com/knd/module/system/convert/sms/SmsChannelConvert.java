package com.w3.module.system.convert.sms;


import com.w3.framework.common.pojo.PageResult;
import com.w3.framework.sms.core.property.SmsChannelProperties;
import com.w3.module.system.controller.admin.sms.vo.channel.SmsChannelCreateReqVO;
import com.w3.module.system.controller.admin.sms.vo.channel.SmsChannelRespVO;
import com.w3.module.system.controller.admin.sms.vo.channel.SmsChannelSimpleRespVO;
import com.w3.module.system.controller.admin.sms.vo.channel.SmsChannelUpdateReqVO;
import com.w3.module.system.dal.dataobject.sms.SmsChannelDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 短信渠道 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface SmsChannelConvert {

    SmsChannelConvert INSTANCE = Mappers.getMapper(SmsChannelConvert.class);

    SmsChannelDO convert(SmsChannelCreateReqVO bean);

    SmsChannelDO convert(SmsChannelUpdateReqVO bean);

    SmsChannelRespVO convert(SmsChannelDO bean);

    List<SmsChannelRespVO> convertList(List<SmsChannelDO> list);

    PageResult<SmsChannelRespVO> convertPage(PageResult<SmsChannelDO> page);

    List<SmsChannelProperties> convertList02(List<SmsChannelDO> list);

    List<SmsChannelSimpleRespVO> convertList03(List<SmsChannelDO> list);

}
