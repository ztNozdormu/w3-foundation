package com.w3.module.system.dal.mysql.mail;


import com.w3.framework.common.pojo.PageResult;
import com.w3.framework.mybatis.core.mapper.BaseMapperX;
import com.w3.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.w3.module.system.controller.admin.mail.vo.log.MailLogPageReqVO;
import com.w3.module.system.dal.dataobject.mail.MailLogDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MailLogMapper extends BaseMapperX<MailLogDO> {

    default PageResult<MailLogDO> selectPage(MailLogPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MailLogDO>()
                .eqIfPresent(MailLogDO::getUserId, reqVO.getUserId())
                .eqIfPresent(MailLogDO::getUserType, reqVO.getUserType())
                .likeIfPresent(MailLogDO::getToMail, reqVO.getToMail())
                .eqIfPresent(MailLogDO::getAccountId, reqVO.getAccountId())
                .eqIfPresent(MailLogDO::getTemplateId, reqVO.getTemplateId())
                .eqIfPresent(MailLogDO::getSendStatus, reqVO.getSendStatus())
                .betweenIfPresent(MailLogDO::getSendTime, reqVO.getSendTime())
                .orderByDesc(MailLogDO::getId));
    }

}
