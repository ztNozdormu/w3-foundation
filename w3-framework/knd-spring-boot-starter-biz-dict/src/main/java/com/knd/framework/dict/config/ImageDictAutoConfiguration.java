package com.knd.framework.dict.config;

import com.knd.framework.dict.core.util.DictFrameworkUtils;
import com.knd.module.system.api.dict.DictDataApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class ImageDictAutoConfiguration {

    @Bean
    @SuppressWarnings("InstantiationOfUtilityClass")
    public DictFrameworkUtils dictUtils(DictDataApi dictDataApi) {
        DictFrameworkUtils.init(dictDataApi);
        return new DictFrameworkUtils();
    }

}
