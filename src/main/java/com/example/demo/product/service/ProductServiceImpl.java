package com.example.demo.product.service;

import com.example.demo.account.service.AccountService;
import com.example.demo.product.controller.form.ProductRegistRequestForm;
import com.example.demo.product.entity.ProductEntity;
import com.example.demo.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    final ProductRepository productRepository;
    final AccountService accountService;
    @Override
    public ProductEntity regist(ProductRegistRequestForm requestForm) {
        if(!accountService.isAccount(requestForm.getUserToken())){
            return null;
        }
        return productRepository.save(requestForm.toProduct());

    }
}