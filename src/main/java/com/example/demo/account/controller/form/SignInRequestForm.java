package com.example.demo.account.controller.form;

import com.example.demo.account.entity.AccountEntity;
import lombok.Getter;

@Getter
public class SignInRequestForm {
    private String email;
    private String password;

    public SignInRequestForm(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
