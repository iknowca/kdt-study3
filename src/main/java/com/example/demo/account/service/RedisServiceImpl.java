package com.example.demo.account.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class RedisServiceImpl implements RedisService{
    final private StringRedisTemplate redisTemplate;

    @Override
    public void setKeyAndValue(String userToken, Long accountId) {
        String accountIdTOString = String.valueOf(accountId);
        ValueOperations<String, String> value = redisTemplate.opsForValue();
        value.set(userToken, accountIdTOString, Duration.ofMinutes(3));
    }

    @Override
    public Long getValueByKey(String userToken) {
        ValueOperations<String, String> value = redisTemplate.opsForValue();
        String tmpAccountId = value.get(userToken);
        Long accountId;

        if(tmpAccountId == null) {
            accountId = null;
        } else {
            accountId = Long.parseLong(tmpAccountId);
        }
        return accountId;
    }
}
