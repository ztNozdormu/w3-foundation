package com.w3.module.system.mq.producer.permission;

import com.w3.framework.mq.core.RedisMQTemplate;
import com.w3.module.system.mq.message.permission.MenuRefreshMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Menu 菜单相关消息的 Producer
 */
@Component
public class MenuProducer {

    @Resource
    private RedisMQTemplate redisMQTemplate;

    /**
     * 发送 {@link MenuRefreshMessage} 消息
     */
    public void sendMenuRefreshMessage() {
        MenuRefreshMessage message = new MenuRefreshMessage();
        redisMQTemplate.send(message);
    }

}
