package com.w3.framework.codegen.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@AutoConfiguration
@EnableConfigurationProperties(CodegenProperties.class)
public class CodegenConfiguration {
}
