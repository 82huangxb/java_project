package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author huangxb
 * @date 2023/2/11 16:23
 * @apiNote
 */
public interface LoadBalancer {
    @SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
