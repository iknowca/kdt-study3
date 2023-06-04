package com.example.demo.account;

import com.example.demo.account.controller.form.SignUpRequestForm;
import com.example.demo.account.entity.AccountEntity;
import com.example.demo.account.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AccountSignUpTest {
    @Autowired
    private AccountService accountService;

    @Test
    @DisplayName("회원가입을합니다.")
    public void 회원가입() {
        final String EMAIL = "test@test.com";
        final String PASSWORD = "PASSWORD";
        AccountEntity savedAccount = accountService.signUp(new SignUpRequestForm(EMAIL, PASSWORD));
        assertEquals(EMAIL, savedAccount.getEmail());
        assertEquals(PASSWORD, savedAccount.getPassword());
    }

    @Test
    @DisplayName("중복된 이메일로 회원가입을 합니다.")
    public void 중복회원가입() {
        final String EMAIL = "test@test.com";
        final String PASSWORD = "PASSWORD2";
        AccountEntity savedAccount = accountService.signUp(new SignUpRequestForm(EMAIL, PASSWORD));
        assertTrue(savedAccount==null);
    }

}
