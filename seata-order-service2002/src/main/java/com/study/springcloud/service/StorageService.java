package com.study.springcloud.service;

/**
 * @author wang
 * @create 2020-11-24-19:26
 */
public interface StorageService {

    // 扣减库存
    void decrease(Long productId, Integer count);
}
