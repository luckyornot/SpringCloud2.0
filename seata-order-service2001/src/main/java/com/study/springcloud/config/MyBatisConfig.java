package com.study.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wang
 * @create 2020-11-24-18:49
 */
@Configuration
@MapperScan({"com.study.springcloud.dao"})
public class MyBatisConfig {
}
