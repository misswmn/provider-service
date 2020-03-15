package com.roncoo.eshop.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangmn
 * @version 1.0
 * @description
 * @date 2020/3/15 19:34
 */
public class IOCTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println(definitionName);
        }
    }
}
