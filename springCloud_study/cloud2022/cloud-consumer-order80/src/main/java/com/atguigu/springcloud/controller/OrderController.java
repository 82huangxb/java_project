package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.PaymentEntity;
import com.atguigu.springcloud.lb.LoadBalancer;
import com.atguigu.springcloud.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/consumer")
public class OrderController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Resource
    @Autowired
    private LoadBalancer loadBalancer;

    public static final String PaymentSrv_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/payment/create") //客户端用浏览器是get请求，但是底层实质发送post调用服务端8001
    public Result create(@RequestBody PaymentEntity entity)
    {
        return restTemplate.postForObject(PaymentSrv_URL + "/payment/create",entity,Result.class);
    }


    @GetMapping(value = "/payment/get/{id}")
    public Result getPayment(@PathVariable Long id)
    {
        return restTemplate.getForObject( PaymentSrv_URL+ "/payment/view?id="+id, Result.class,id);
    }

    @GetMapping(value = "/payment/getEntity/{id}")
    public Result getPayment2(@PathVariable Long id)
    {
        ResponseEntity<Result> forEntity =
                restTemplate.getForEntity(PaymentSrv_URL + "/payment/view?id=" + id, Result.class, id);
        if(forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else{
            return Result.fail("访问失败");
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB()
    {
        //获取该微服务上的所有服务器
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if(instances == null || instances.size()<=0) {
            return null;
        }
        //根据自定义轮训算法算出当前是那一台服务器
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

}
