package com.w3.module.system.dal.mysql.sensitiveword;


import com.w3.framework.common.pojo.PageResult;
import com.w3.framework.mybatis.core.mapper.BaseMapperX;
import com.w3.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.w3.module.system.controller.admin.sensitiveword.vo.SensitiveWordExportReqVO;
import com.w3.module.system.controller.admin.sensitiveword.vo.SensitiveWordPageReqVO;
import com.w3.module.system.dal.dataobject.sensitiveword.SensitiveWordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 敏感词 Mapper
 *
 * @author 永不言败
 */
@Mapper
public interface SensitiveWordMapper extends BaseMapperX<SensitiveWordDO> {

    default PageResult<SensitiveWordDO> selectPage(SensitiveWordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SensitiveWordDO>()
                .likeIfPresent(SensitiveWordDO::getName, reqVO.getName())
                .likeIfPresent(SensitiveWordDO::getTags, reqVO.getTag())
                .eqIfPresent(SensitiveWordDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(SensitiveWordDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SensitiveWordDO::getId));
    }

    default List<SensitiveWordDO> selectList(SensitiveWordExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<SensitiveWordDO>()
                .likeIfPresent(SensitiveWordDO::getName, reqVO.getName())
                .likeIfPresent(SensitiveWordDO::getTags, reqVO.getTag())
                .eqIfPresent(SensitiveWordDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(SensitiveWordDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SensitiveWordDO::getId));
    }

    default SensitiveWordDO selectByName(String name) {
        return selectOne(SensitiveWordDO::getName, name);
    }

}
