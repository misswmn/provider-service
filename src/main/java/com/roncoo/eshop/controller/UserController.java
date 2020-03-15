package com.roncoo.eshop.controller;

import com.roncoo.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-03-10 23:24
 */
@RestController
public class UserController {

    @Autowired
    private UserService usersService;

    @GetMapping(value = "/user/list")
    public List<?> list() {
        return usersService.list();
    }
}
