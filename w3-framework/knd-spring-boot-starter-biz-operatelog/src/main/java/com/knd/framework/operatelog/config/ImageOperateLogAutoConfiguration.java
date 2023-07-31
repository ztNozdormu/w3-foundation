package com.knd.framework.operatelog.config;


import com.knd.framework.operatelog.core.aop.OperateLogAspect;
import com.knd.framework.operatelog.core.service.OperateLogFrameworkService;
import com.knd.framework.operatelog.core.service.OperateLogFrameworkServiceImpl;
import com.knd.module.system.api.logger.OperateLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class ImageOperateLogAutoConfiguration {

    @Bean
    public OperateLogAspect operateLogAspect() {
        return new OperateLogAspect();
    }

    @Bean
    public OperateLogFrameworkService operateLogFrameworkService(OperateLogApi operateLogApi) {
        return new OperateLogFrameworkServiceImpl(operateLogApi);
    }

}
