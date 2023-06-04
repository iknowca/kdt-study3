package com.example.demo.account.service;

import com.example.demo.account.controller.form.SignInRequestForm;
import com.example.demo.account.controller.form.SignUpRequestForm;
import com.example.demo.account.entity.AccountEntity;
import com.example.demo.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
    final AccountRepository accountRepository;
    @Override
    public AccountEntity signUp(SignUpRequestForm requestForm) {
        Optional<AccountEntity> maybeAccount = accountRepository.findByEmail(requestForm.getEmail());
        if(maybeAccount.isPresent()) {
            return null;
        }

        AccountEntity newAccount = requestForm.toAccount();

        return  accountRepository.save(newAccount);
    }

    @Override
    public AccountEntity signIn(SignInRequestForm requestForm) {
        Optional<AccountEntity> maybeAccount = accountRepository.findByEmail(requestForm.getEmail());
        if(maybeAccount.isEmpty()){
            return null;
        }
        if(!maybeAccount.get().getPassword().equals(requestForm.getPassword())){
            return null;
        }
        AccountEntity savedAccount = maybeAccount.get();
        savedAccount.setUserToken(UUID.randomUUID().toString());
        return accountRepository.save(savedAccount);
    }

    @Override
    public boolean isAccount(String userToken) {
        Optional<AccountEntity> maybeAccount = accountRepository.findByUserToken(userToken);
        if(maybeAccount.isPresent()){
            return true;
        }
        return false;
    }


}
