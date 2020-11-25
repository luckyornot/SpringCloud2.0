package com.study.springcloud.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wang
 * @create 2020-11-24-19:22
 */
@Data
public class Storage implements Serializable {

    private Long id;

    // 产品id
    private Long productId;

    //总库存
    private Integer total;


    //已用库存
    private Integer used;


    //剩余库存
    private Integer residue;
}
