package com.example.demo.account;

import com.example.demo.account.controller.form.SignInRequestForm;
import com.example.demo.account.entity.AccountEntity;
import com.example.demo.account.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AccountSignInTest {

    @Autowired
    AccountService accountService;
    @Test
    @DisplayName("정상적인 로그인을 시도 합니다")
    public void 정상적인_로그인() {
        final String EMAIL = "test@test.com";
        final String PASSWORD = "PASSWORD";
        SignInRequestForm requestForm = new SignInRequestForm(EMAIL, PASSWORD);
        AccountEntity savedAccount = accountService.signIn(requestForm);

        assertEquals(savedAccount.getEmail(), EMAIL);
        assertEquals(savedAccount.getPassword(), PASSWORD);
        System.out.println("userToken: "+savedAccount.getUserToken());
    }

    @Test
    @DisplayName("적합하지 않은 로그인을 시도 합니다.1")
    public void 없는이메일로_로그인() {
        final String EMAIL = "NOEMAIL";
        final String PASSWORD = "PASSWORD";
        SignInRequestForm requestForm = new SignInRequestForm(EMAIL, PASSWORD);
        AccountEntity savedAccount = accountService.signIn(requestForm);

        assertTrue(savedAccount==null);
    }

    @Test
    @DisplayName("적합하지 않은 로그인을 시도 합니다.2")
    public void 틀린비밀번호로_로그인() {
        final String EMAIL = "test@test.com";
        final String PASSWORD = "NOPASSWORD";
        SignInRequestForm requestForm = new SignInRequestForm(EMAIL, PASSWORD);
        AccountEntity savedAccount = accountService.signIn(requestForm);

        assertTrue(savedAccount==null);
    }
}
