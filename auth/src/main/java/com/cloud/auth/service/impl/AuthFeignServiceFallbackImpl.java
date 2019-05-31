package com.cloud.auth.service.impl;

import com.cloud.auth.service.AuthFeignService;
import org.springframework.stereotype.Component;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/31 14:24
 * @Description:
 */
@Component
public class AuthFeignServiceFallbackImpl implements AuthFeignService {
    @Override
    public String hello(String name) {
        return "hello"+name+"this is error";
    }
}
