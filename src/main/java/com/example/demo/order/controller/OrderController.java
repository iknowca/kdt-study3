package com.example.demo.order.controller;

import com.example.demo.order.controller.form.OrderRegistForm;
import com.example.demo.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    final OrderService orderService;

    @PostMapping("/regist")
    public Long orderRegist(OrderRegistForm registForm) {
        return orderService.regist(registForm).getId();
    }


}
