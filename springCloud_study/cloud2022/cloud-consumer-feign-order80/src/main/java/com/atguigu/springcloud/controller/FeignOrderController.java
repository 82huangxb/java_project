package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.feign.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangxb
 * @date 2023/2/11 17:56
 * @apiNote
 */
@RestController
@RequestMapping(value = "/feign")
public class FeignOrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        String paymentLB = paymentFeignService.getPaymentLB();
        return paymentLB;
    }
}
