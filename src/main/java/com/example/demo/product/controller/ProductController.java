package com.example.demo.product.controller;

import com.example.demo.product.controller.form.ProductRegistRequestForm;
import com.example.demo.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    final ProductService productService;

    @PostMapping("/regist")
    public Long regist(ProductRegistRequestForm requestForm) {
        return productService.regist(requestForm).getId();
    }
}
