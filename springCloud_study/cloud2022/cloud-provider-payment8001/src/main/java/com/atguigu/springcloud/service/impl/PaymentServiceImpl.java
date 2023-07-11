package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entity.PaymentEntity;
import com.atguigu.springcloud.mapper.PaymentMapper;
import com.atguigu.springcloud.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class PaymentServiceImpl implements IPaymentService {

    @Autowired
    private PaymentMapper mapper;

    @Override
    public int create(PaymentEntity entity) {
        return mapper.insert(entity);
    }

    @Override
    public PaymentEntity view(Long id) {
        return mapper.selectById(id);
    }
}
