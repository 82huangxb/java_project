package com.atguigu.springcloud.feign;

import com.atguigu.springcloud.feign.impl.FeignPaymenFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author huangxb
 * @date 2023/2/24 17:51
 * @apiNote
 */
@Component
/**
 * 通过openfeign中指定降级的方法 用来防止调用的服务器宕机 超时 异常等问题
 * @FeignClient(fallback="指定降级的方法")
 */
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = FeignPaymenFallback.class)
public interface FeignPayment {

    @GetMapping("/hystrix/ok")
    String paymentInfo_OK(@RequestParam("id") Integer id);

    @GetMapping("/hystrix/timeOut")
    String paymentInfo_TimeOut(@RequestParam("id") Integer id);
}
