package com.atguigu.springcloud.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("payment")
public class PaymentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("id")
    private Long id;

    @TableField("serial")
    private String serial;

}
