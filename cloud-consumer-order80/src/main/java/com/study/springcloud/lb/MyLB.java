package com.study.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wang
 * @create 2020-11-19-10:01
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    // 自旋锁
    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;

        }while(!this.atomicInteger.compareAndSet(current, next));// 第一个参数是期望值，第二个参数是修改值
        System.out.println("*******第几次访问，次数next: "+next);

        return next;
    }

    // 收集服务器总共有多少台能够提供服务的机器，并放到list里面
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        // 得到服务器的下标位置
        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
