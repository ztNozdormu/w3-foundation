package com.w3.module.infra.mq.message.file;

import com.w3.framework.mq.core.pubsub.AbstractChannelMessage;
import lombok.Data;

/**
 * 文件配置数据刷新 Message
 */
@Data
public class FileConfigRefreshMessage extends AbstractChannelMessage {

    @Override
    public String getChannel() {
        return "infra.file-config.refresh";
    }

}
