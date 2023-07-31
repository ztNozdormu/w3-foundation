package com.knd.framework.monitor.tracer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * BizTracer配置类
 *
 * @author 麻薯
 */
@ConfigurationProperties("knd.tracer")
@Data
public class TracerProperties {
}
