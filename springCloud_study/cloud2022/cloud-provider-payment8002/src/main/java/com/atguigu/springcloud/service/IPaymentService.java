package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.PaymentEntity;

public interface IPaymentService {
    @SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
    int create(PaymentEntity entity);

    @SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
    PaymentEntity view(Long id);
}
