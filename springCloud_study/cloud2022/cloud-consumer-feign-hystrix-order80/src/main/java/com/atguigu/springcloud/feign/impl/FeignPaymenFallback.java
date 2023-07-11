package com.atguigu.springcloud.feign.impl;

import com.atguigu.springcloud.feign.FeignPayment;
import org.springframework.stereotype.Component;

/**
 * @author huangxb
 * @date 2023/2/25 16:03
 * @apiNote
 */
@Component
public class FeignPaymenFallback implements FeignPayment {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80";

    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80";
    }
}
