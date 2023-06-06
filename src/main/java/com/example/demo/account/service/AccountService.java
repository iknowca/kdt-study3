package com.example.demo.account.service;

import com.example.demo.account.controller.form.SignInRequestForm;
import com.example.demo.account.controller.form.SignUpRequestForm;
import com.example.demo.account.entity.AccountEntity;

public interface AccountService {
    AccountEntity signUp(SignUpRequestForm requestForm);

    AccountEntity signIn(SignInRequestForm requestForm);

    AccountEntity getByUserToken(String userToken);
}
