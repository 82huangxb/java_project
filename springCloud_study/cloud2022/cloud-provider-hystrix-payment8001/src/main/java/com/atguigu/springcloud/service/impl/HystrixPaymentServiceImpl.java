package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.HystrixPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author huangxb
 * @date 2023/2/24 16:53
 * @apiNote
 */
@Service
public class HystrixPaymentServiceImpl implements HystrixPaymentService {

    /**
     * 正常访问，一切OK
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_OK(Integer id)
    {
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_OK,id: "+id+"\t"+"O(∩_∩)O";
    }

    /**
     * 超时访问，演示降级
     * @param id
     * @return
     */

    /**
     指定服务降级之后的方法
     一旦调用服务方法失败并抛出了错误信息后，
     会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            //超时时间降级服务
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    @Override
    public String paymentInfo_TimeOut(Integer id)
    {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_TimeOut,id: "+id+"\t"+"O(∩_∩)O，耗费3秒";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOutHandler"+"服务降级了o(╥﹏╥)o";
    }
}
