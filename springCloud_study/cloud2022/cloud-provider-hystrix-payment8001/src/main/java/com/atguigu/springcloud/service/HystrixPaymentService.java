package com.atguigu.springcloud.service;

/**
 * @author huangxb
 * @date 2023/2/24 16:53
 * @apiNote
 */
public interface HystrixPaymentService {

    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id);
}
