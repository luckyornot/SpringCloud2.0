package com.study.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wang
 * @create 2020-11-17-12:07
 */
@Configuration
public class ApplicationContextConfig {

    //@LoadBalanced // 指定负载均衡机制
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
