package com.example.demo.account.service;

public interface RedisService {

    void setKeyAndValue(String userToken, Long accountId);
    Long getValueByKey(String userToken);
}
