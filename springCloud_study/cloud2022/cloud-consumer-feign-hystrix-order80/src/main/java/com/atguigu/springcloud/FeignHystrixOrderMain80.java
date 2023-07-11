package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author huangxb
 * @date ${DATE} ${TIME}
 * @apiNote
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class FeignHystrixOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixOrderMain80.class,args);
        System.out.println("Hello world!");
    }
}