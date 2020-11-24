package com.study.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.study.springcloud.entities.CommonResult;

/**
 * @author wang
 * @create 2020-11-23-19:57
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler");

    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 222服务不可用");
    }
}