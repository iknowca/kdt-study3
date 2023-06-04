package com.example.demo.product;

import com.example.demo.product.controller.form.ProductRegistRequestForm;
import com.example.demo.product.entity.ProductEntity;
import com.example.demo.product.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ProductRegistTest {
    @Autowired
    ProductService productService;
    @Test
    @DisplayName("회원이 상품을 등록합니다")
    public void 상품등록() {
        String userToken ="b40e19ee-9fec-4684-8887-e5a9033d52dd";
        String prodName = "prod1";
        Integer prodPrice = 1000;
        String prodInfo = "prodInfo";
        ProductRegistRequestForm requestForm = new ProductRegistRequestForm(userToken, prodName, prodPrice, prodInfo);

        ProductEntity savedProduct = productService.regist(requestForm);

        assertEquals(savedProduct.getName(), prodName);
        assertEquals(savedProduct.getPrice(), prodPrice);
        assertEquals(savedProduct.getInfo(), prodInfo);
    }

    @Test
    @DisplayName("올바르지 않은 회원이 상품을 등록합니다")
    public void 비정상_상품등록() {
        String userToken ="NOUSER";
        String prodName = "prod1";
        Integer prodPrice = 1000;
        String prodInfo = "prodInfo";
        ProductRegistRequestForm requestForm = new ProductRegistRequestForm(userToken, prodName, prodPrice, prodInfo);

        ProductEntity savedProduct = productService.regist(requestForm);

        assertTrue(savedProduct==null);
    }
}
