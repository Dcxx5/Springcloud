package com.cloudlean.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: cuibaoluo
 * @Date: 2019/5/31 13:50
 * @Description:
 */
@RestController
public class TestController {

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "hello"+name+"this admin";
    }
}
