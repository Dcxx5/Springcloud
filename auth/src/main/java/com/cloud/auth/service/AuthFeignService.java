package com.cloud.auth.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/31 14:05
 * @Description:
 */
@FeignClient(value="admin")
public interface AuthFeignService {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable(name="name") String name);
}
