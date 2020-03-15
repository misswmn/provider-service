package com.roncoo.eshop.juc.c022;

import java.io.IOException;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-26 21:15
 */
public class NormalReference {

    public static void main(String[] args) throws IOException {
        M m = new M();
        m = null;
        System.gc(); //DisableExplicitGC

        System.in.read();
    }
}
