package com.cloud.auth.controller;

import com.cloud.auth.service.AuthFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/31 14:00
 * @Description:
 */
@RestController
public class AuthController {
    @Autowired
    private AuthFeignService authFeignService;

    @GetMapping("/autoHello/{name}")
    public String auth(@PathVariable String name) {
        return authFeignService.hello(name);
    }

}
