package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.feign.FeignPayment;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangxb
 * @date 2023/2/24 17:53
 * @apiNote
 */
@RequestMapping("/hystrix")
@RestController
/**
 * 1、每个业务方法对应一个兜底的方法，代码膨胀
 * 2、除了个别重要核心业务有专属，其它普通的可以通过@DefaultProperties(defaultFallback = "")  统一跳转到统一处理结果页面
 * 3、通用的和独享的各自分开，避免了代码膨胀
 */
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class FeignHystrixController {

    @Autowired
    private FeignPayment feignPayment;

    @GetMapping("/payment/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id)
    {
        String result = feignPayment.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/payment/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id)
    {
        String result = feignPayment.paymentInfo_TimeOut(id);
        return result;
    }

    @HystrixCommand
    @GetMapping("/payment/defaultOk/{id}")
    public String defaultOk(@PathVariable("id") Integer id)
    {
        int i = 8/0;
        return "我自己调用自己的接口";
    }

    /**
     * 该方法是默认的服务降级方法
     * @return
     */
    public String payment_Global_FallbackMethod(){
        return "80自己服务降级";
    }
}
