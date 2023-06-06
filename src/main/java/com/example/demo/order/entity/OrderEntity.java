package com.example.demo.order.entity;

import com.example.demo.account.entity.AccountEntity;
import com.example.demo.product.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class OrderEntity {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    AccountEntity buyerAccount;
    @ManyToOne(fetch = FetchType.LAZY)
    ProductEntity productEntity;


    public OrderEntity(AccountEntity buyerAccount, ProductEntity productEntity) {
        this.buyerAccount = buyerAccount;
        this.productEntity = productEntity;
    }

    @CreatedDate
    LocalDateTime createdDate;

}
