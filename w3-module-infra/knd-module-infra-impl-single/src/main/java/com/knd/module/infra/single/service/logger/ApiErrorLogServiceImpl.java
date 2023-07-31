package com.knd.module.infra.single.service.logger;


import com.knd.framework.common.pojo.PageResult;
import com.knd.module.infra.api.dal.dataobject.logger.ApiErrorLogDO;
import com.knd.module.infra.api.enums.logger.ApiErrorLogProcessStatusEnum;
import com.knd.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import com.knd.module.infra.single.controller.admin.logger.vo.apierrorlog.ApiErrorLogExportReqVO;
import com.knd.module.infra.single.controller.admin.logger.vo.apierrorlog.ApiErrorLogPageReqVO;
import com.knd.module.infra.single.convert.logger.ApiErrorLogConvert;
import com.knd.module.infra.single.dal.mysql.logger.ApiErrorLogMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

import static com.knd.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.knd.module.infra.api.enums.ErrorCodeConstants.*;


/**
 * API 错误日志 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ApiErrorLogServiceImpl implements ApiErrorLogService {

    @Resource
    private ApiErrorLogMapper apiErrorLogMapper;

    @Override
    public void createApiErrorLog(ApiErrorLogCreateReqDTO createDTO) {
        ApiErrorLogDO apiErrorLog = ApiErrorLogConvert.INSTANCE.convert(createDTO)
                .setProcessStatus(ApiErrorLogProcessStatusEnum.INIT.getStatus());
        apiErrorLogMapper.insert(apiErrorLog);
    }

    @Override
    public PageResult<ApiErrorLogDO> getApiErrorLogPage(ApiErrorLogPageReqVO pageReqVO) {
        return apiErrorLogMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ApiErrorLogDO> getApiErrorLogList(ApiErrorLogExportReqVO exportReqVO) {
        return apiErrorLogMapper.selectList(exportReqVO);
    }

    @Override
    public void updateApiErrorLogProcess(Long id, Integer processStatus, Long processUserId) {
        ApiErrorLogDO errorLog = apiErrorLogMapper.selectById(id);
        if (errorLog == null) {
            throw exception(API_ERROR_LOG_NOT_FOUND);
        }
        if (!ApiErrorLogProcessStatusEnum.INIT.getStatus().equals(errorLog.getProcessStatus())) {
            throw exception(API_ERROR_LOG_PROCESSED);
        }
        // 标记处理
        apiErrorLogMapper.updateById(ApiErrorLogDO.builder().id(id).processStatus(processStatus)
                .processUserId(processUserId).processTime(LocalDateTime.now()).build());
    }

}
