package com.w3.module.system.mq.message.dept;

import com.w3.framework.mq.core.pubsub.AbstractChannelMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门数据刷新 Message
 *
 * @author 芋道源码
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptRefreshMessage extends AbstractChannelMessage {

    @Override
    public String getChannel() {
        return "system.dept.refresh";
    }

}
