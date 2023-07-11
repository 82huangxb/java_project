package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangxb
 * @date 2023/2/10 15:26
 * @apiNote
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule()
    {
        //定义为随机
        return new RandomRule();
    }
}
