package com.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wang
 * @create 2020-11-22-17:08
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain9011 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9011.class,args);
    }
}
