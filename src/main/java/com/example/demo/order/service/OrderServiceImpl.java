package com.example.demo.order.service;

import com.example.demo.account.entity.AccountEntity;
import com.example.demo.account.service.AccountService;
import com.example.demo.order.controller.form.OrderRegistForm;
import com.example.demo.order.entity.OrderEntity;
import com.example.demo.order.repository.OrderRepository;
import com.example.demo.product.entity.ProductEntity;
import com.example.demo.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    final OrderRepository orderRepository;
    final AccountService accountService;
    final ProductService productService;

    public OrderEntity regist(OrderRegistForm registForm) {
        AccountEntity account = accountService.getByUserToken(registForm.getUserToken());
        if(account==null) {
            return null;
        }
        ProductEntity product = productService.getByProductId(registForm.getProductId());
        if(product==null) {
            return null;
        }
        return new OrderEntity(account, product);
    }
}
