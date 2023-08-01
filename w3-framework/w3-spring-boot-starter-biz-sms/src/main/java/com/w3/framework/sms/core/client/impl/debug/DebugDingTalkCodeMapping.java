package com.w3.framework.sms.core.client.impl.debug;

import com.w3.framework.common.exception.ErrorCode;
import com.w3.framework.common.exception.enums.GlobalErrorCodeConstants;
import com.w3.framework.sms.core.client.SmsCodeMapping;
import com.w3.framework.sms.core.enums.SmsFrameworkErrorCodeConstants;

import java.util.Objects;

/**
 * 钉钉的 SmsCodeMapping 实现类
 *
 * @author 芋道源码
 */
public class DebugDingTalkCodeMapping implements SmsCodeMapping {

    @Override
    public ErrorCode apply(String apiCode) {
        return Objects.equals(apiCode, "0") ? GlobalErrorCodeConstants.SUCCESS : SmsFrameworkErrorCodeConstants.SMS_UNKNOWN;
    }

}
