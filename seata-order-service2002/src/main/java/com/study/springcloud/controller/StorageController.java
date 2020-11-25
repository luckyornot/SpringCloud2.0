package com.study.springcloud.controller;

import com.study.springcloud.domain.CommonResult;
import com.study.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wang
 * @create 2020-11-24-19:28
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    // 扣减库存
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {

        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功！");
    }
}
