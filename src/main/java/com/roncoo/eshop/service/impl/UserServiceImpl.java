package com.roncoo.eshop.service.impl;

import com.roncoo.eshop.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-03-10 23:25
 */
@Service
public class UserServiceImpl implements UserService {

    @Transactional
    @Override
    public List<?> list() {
        System.out.println("xxx");
        return Arrays.asList(1, 2, 3, 4, 5);
    }
}
