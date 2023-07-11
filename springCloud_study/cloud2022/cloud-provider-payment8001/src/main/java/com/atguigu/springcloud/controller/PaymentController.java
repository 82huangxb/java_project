package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entity.PaymentEntity;
import com.atguigu.springcloud.service.IPaymentService;
import com.atguigu.springcloud.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private IPaymentService service;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/create")
    public Result create(@RequestBody PaymentEntity entity){
        int result = service.create(entity);
        if(result>0){
            return Result.success("创建成功,端口号是"+serverPort);
        }else{
            return Result.fail("创建失败");
        }
    }

    @GetMapping(value = "/view")
    public Result view(@RequestParam Long id){
        return Result.success("返回数据成功,端口号是"+serverPort,service.view(id));
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }



}
