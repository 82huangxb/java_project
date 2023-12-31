package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author huangxb
 * @date ${DATE} ${TIME}
 * @apiNote
 */

/**
该注解用于向使用consul或者zookeeper作为注册中心时注册服务
*/
@SuppressWarnings("ALL")
@EnableDiscoveryClient
@SpringBootApplication
public class OrderConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class,args);
        System.out.println("Hello world!");
    }
}