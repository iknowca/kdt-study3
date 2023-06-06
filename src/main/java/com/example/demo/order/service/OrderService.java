package com.example.demo.order.service;

import com.example.demo.order.controller.form.OrderRegistForm;
import com.example.demo.order.entity.OrderEntity;

public interface OrderService {
     OrderEntity regist(OrderRegistForm registForm);
}
