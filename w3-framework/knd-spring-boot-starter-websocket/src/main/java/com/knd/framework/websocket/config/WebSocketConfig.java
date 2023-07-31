package com.knd.framework.websocket.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * websocket 配置
 */
@AutoConfiguration
@Slf4j
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        log.info("初始化 WebSocket 自动配置");
        return new ServerEndpointExporter();
    }
}
