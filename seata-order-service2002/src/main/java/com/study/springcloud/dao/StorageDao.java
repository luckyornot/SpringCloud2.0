package com.study.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wang
 * @create 2020-11-24-19:24
 */
@Mapper
public interface StorageDao {

    // 扣减库存信息
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
