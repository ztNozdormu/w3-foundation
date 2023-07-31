package com.knd.module.infra.single.dal.mysql.file;


import com.knd.framework.common.pojo.PageResult;
import com.knd.framework.mybatis.core.mapper.BaseMapperX;
import com.knd.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.knd.module.infra.api.dal.dataobject.file.FileDO;
import com.knd.module.infra.single.controller.admin.file.vo.file.FilePageReqVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件操作 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface FileMapper extends BaseMapperX<FileDO> {

    default PageResult<FileDO> selectPage(FilePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FileDO>()
                .likeIfPresent(FileDO::getPath, reqVO.getPath())
                .likeIfPresent(FileDO::getType, reqVO.getType())
                .betweenIfPresent(FileDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(FileDO::getId));
    }

}
