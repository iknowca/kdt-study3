package com.example.demo.order.controller.form;

import com.example.demo.order.entity.OrderEntity;
import lombok.Getter;

@Getter
public class OrderRegistForm {
    private String userToken;
    private Long productId;
}
