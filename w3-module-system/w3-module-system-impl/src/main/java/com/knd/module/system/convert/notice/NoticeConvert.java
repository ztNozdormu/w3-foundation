package com.w3.module.system.convert.notice;

import com.w3.framework.common.pojo.PageResult;
import com.w3.module.system.controller.admin.notice.vo.NoticeCreateReqVO;
import com.w3.module.system.controller.admin.notice.vo.NoticeRespVO;
import com.w3.module.system.controller.admin.notice.vo.NoticeUpdateReqVO;
import com.w3.module.system.dal.dataobject.notice.NoticeDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NoticeConvert {

    NoticeConvert INSTANCE = Mappers.getMapper(NoticeConvert.class);

    PageResult<NoticeRespVO> convertPage(PageResult<NoticeDO> page);

    NoticeRespVO convert(NoticeDO bean);

    NoticeDO convert(NoticeUpdateReqVO bean);

    NoticeDO convert(NoticeCreateReqVO bean);

}
