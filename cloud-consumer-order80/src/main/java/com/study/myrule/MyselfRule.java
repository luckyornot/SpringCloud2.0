package com.study.myrule;

        import com.netflix.loadbalancer.IRule;
        import com.netflix.loadbalancer.RandomRule;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

/**
 * @author wang
 * @create 2020-11-18-10:51
 *
 * 定义ribbon负载均衡机制，默认不能放在componentScan下面，所以另外建包和类
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule iRule(){

        return new RandomRule(); // 随机
    }
}
