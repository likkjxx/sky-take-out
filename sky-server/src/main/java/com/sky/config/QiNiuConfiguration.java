package com.sky.config;

import com.sky.properties.AliOssProperties;
import com.sky.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类，创建AliOssUtil对象
 */

@Configuration
@Slf4j
public class QiNiuConfiguration {

    @Bean
    public AliOssUtil aliOssUtil(AliOssProperties aliOssProperties){

        log.info("开始创建文件上传工具类对象：{}",aliOssProperties);

       return new AliOssUtil(aliOssProperties);
    }



}
