package com.roncoo.eshop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-22 20:55
 */
@RestController
public class HelloController {
    @Value("${server.port}")
    public String port;

    @RequestMapping(value = "/hello")
    public String hello(String name) {
        return "hello, " + name + " from " + port;
    }
}
