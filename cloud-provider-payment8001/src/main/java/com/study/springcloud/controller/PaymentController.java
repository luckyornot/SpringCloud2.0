package com.study.springcloud.controller;

import com.study.springcloud.entities.CommonResult;
import com.study.springcloud.entities.Payment;
import com.study.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author wang
 * @create 2020-11-16-21:38
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi ,i'am paymentzipkin server fall back，welcome to wang，O(∩_∩)O哈哈~";
    }

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("***插入结果：" + result);
        if(result > 0){
            return new CommonResult(200, "插入数据成功！" + serverPort, result);
        }else {
            return new CommonResult(444, "插入数据失败！" + serverPort, null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("***插入结果：" + payment + "ceshi");
        if(payment != null){
            return new CommonResult(200, "查询成功！" + serverPort, payment);
        }else {
            return new CommonResult(444, "没有对应记录！Id = " + id + serverPort, null);
        }
    }

    // 服务发现，获取在eureka上已注册的服务
    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("elements: " + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+ "\t" + instance.getHost()+"\t" + instance.getPort()+"\t"+instance.getUri());
        }

        return discoveryClient;
    }

    // 获取端口号
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    // 模拟暂停几秒钟超时
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return serverPort;
    }
}
