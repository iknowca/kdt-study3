package com.example.demo.product.controller.form;

import com.example.demo.product.entity.ProductEntity;
import lombok.Getter;

public class ProductRegistRequestForm {
    @Getter
    private String userToken;
    private String productName;
    private Integer productPrice;
    private String productInfo;
    public ProductEntity toProduct() {
        return new ProductEntity(productName, productPrice, productInfo);
    }

    public ProductRegistRequestForm(String userToken, String productName, Integer productPrice, String productInfo) {
        this.userToken = userToken;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productInfo = productInfo;
    }
}
