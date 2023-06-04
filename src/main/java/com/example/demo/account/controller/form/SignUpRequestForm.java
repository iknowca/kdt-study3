package com.example.demo.account.controller.form;

import com.example.demo.account.entity.AccountEntity;
import lombok.Getter;

@Getter
public class SignUpRequestForm {
    private String email;
    private String password;

    public SignUpRequestForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AccountEntity toAccount() {
        return new AccountEntity(this.email, this.password);
    }
}
