package com.example.demo.order;

import com.example.demo.order.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderRegistTest {
    @Autowired
    private OrderService orderService;
    @Test
    @DisplayName("")
    public void 회원상품등록() {

    }
}
