package com.example.demo.account.controller;

import com.example.demo.account.controller.form.SignInRequestForm;
import com.example.demo.account.controller.form.SignUpRequestForm;
import com.example.demo.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
@Slf4j
public class AccountController {
    final AccountService accountService;
    @PostMapping("/sign-up")
    public Long signUp(SignUpRequestForm requestForm) {
        return accountService.signUp(requestForm).getId();
    }

    @PostMapping("/sign-in")
    public String signIn(SignInRequestForm requestForm) {
        return accountService.signIn(requestForm).getUserToken();
    }


}
