package com.knd.module.infra.single.api.logger;

import com.knd.module.infra.api.logger.ApiAccessLogApi;
import com.knd.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;
import com.knd.module.infra.single.service.logger.ApiAccessLogService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * API 访问日志的 API 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ApiAccessLogApiImpl implements ApiAccessLogApi {

    @Resource
    private ApiAccessLogService apiAccessLogService;

    @Override
    public void createApiAccessLog(ApiAccessLogCreateReqDTO createDTO) {
        apiAccessLogService.createApiAccessLog(createDTO);
    }

}
