package com.example.demo.product.service;

import com.example.demo.product.controller.form.ProductRegistRequestForm;
import com.example.demo.product.entity.ProductEntity;

public interface ProductService {
    ProductEntity regist(ProductRegistRequestForm requestForm);
    ProductEntity getByProductId(Long productId);
}
