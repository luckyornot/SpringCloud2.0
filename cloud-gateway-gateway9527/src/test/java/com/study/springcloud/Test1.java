package com.study.springcloud;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author wang
 * @create 2020-11-20-16:23
 */
public class Test1 {

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(); // 默认时区
        System.out.println(zonedDateTime); // 2020-11-20T16:24:38.707+08:00[Asia/Shanghai]

        ZonedDateTime znj = ZonedDateTime.now(ZoneId.of("America/New_York")); // 用指定时区获取当前时间
        System.out.println(znj); // 2020-11-20T03:26:38.159-05:00[America/New_York]

    }
}
