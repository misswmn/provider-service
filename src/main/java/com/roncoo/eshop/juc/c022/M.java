package com.roncoo.eshop.juc.c022;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-26 21:17
 */
public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
