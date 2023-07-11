package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.HystrixPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangxb
 * @date 2023/2/24 16:52
 * @apiNote
 */
@RestController
@RequestMapping(value = "/hystrix")
public class HystrixPaymentController {

    @Autowired
    private HystrixPaymentService hystrixPaymentService;

    @GetMapping("/ok")
    public String paymentInfo_OK(@RequestParam Integer id){
        return hystrixPaymentService.paymentInfo_OK(id);
    }

    @GetMapping("/timeOut")
    public String paymentInfo_TimeOut(@RequestParam Integer id){
        return hystrixPaymentService.paymentInfo_TimeOut(id);
    }
}
