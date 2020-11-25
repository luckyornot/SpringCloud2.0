package com.study.springcloud.dao;

import com.study.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wang
 * @create 2020-11-24-18:42
 */
@Mapper
public interface OrderDao {

    // 新建订单
    void create(Order order);

    // 修改订单状态，从零改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}