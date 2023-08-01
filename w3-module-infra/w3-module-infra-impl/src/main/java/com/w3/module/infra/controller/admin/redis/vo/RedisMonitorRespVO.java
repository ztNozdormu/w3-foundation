package com.w3.module.infra.controller.admin.redis.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Properties;

/**
 * description = "管理后台 - Redis 监控信息 Response VO"
 */
@Data
@Builder
@AllArgsConstructor
public class RedisMonitorRespVO {

    /**
     * description = "Redis info 指令结果,具体字段，查看 Redis 文档", requiredMode = Schema.RequiredMode.REQUIRED
     */
    private Properties info;

    /**
     * description = "Redis key 数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
     */
    private Long dbSize;

    /**
     * description = "CommandStat 数组", requiredMode = Schema.RequiredMode.REQUIRED
     */
    private List<CommandStat> commandStats;

    /**
     * description = "Redis 命令统计结果"
     */
    @Data
    @Builder
    @AllArgsConstructor
    public static class CommandStat {

        /**
         * description = "Redis 命令", requiredMode = Schema.RequiredMode.REQUIRED, example = "get"
         */
        private String command;

        /**
         * description = "调用次数", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024"
         */
        private Long calls;

        /**
         * description = "消耗 CPU 秒数", requiredMode = Schema.RequiredMode.REQUIRED, example = "666"
         */
        private Long usec;

    }

}
