package com.w3.module.biz.marketdata.enums;// TODO 待办：请将下面的错误码复制到 yudao-module-mk-api 模块的 ErrorCodeConstants 类中。注意，请给“TODO 补充编号”设置一个错误码编号！！！
// ========== TOKEN基本信息 TODO 补充编号 ==========

import com.w3.framework.common.exception.ErrorCode;

/**
 * Mktdata 错误码枚举类
 *
 * infra 系统，使用 1-003-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== 参数配置 1003000000 ==========
    ErrorCode CONFIG_NOT_EXISTS = new ErrorCode(1003000000, "参数配置不存在");

    // ========== 代币信息 1003000001 ==========
    ErrorCode TOKEN_INFO_NOT_EXISTS = new ErrorCode(1003000001, "代币信息不存在");
    // ========== 代币排名信息 1003000002 ==========
    ErrorCode TOKEN_RANK_NOT_EXISTS = new ErrorCode(1003000002, "代币排名信息不存在");

}
