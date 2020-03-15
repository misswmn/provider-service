package com.roncoo.eshop.juc;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-25 19:05
 */
//import sun.misc.*;

import sun.misc.Unsafe;

public class HelloUnsafe {
    static class M {
        private M() {}

        int i =0;
    }

    public static void main(String[] args) throws InstantiationException {
        Unsafe unsafe = Unsafe.getUnsafe();
        M m = (M)unsafe.allocateInstance(M.class);
        m.i = 9;
        System.out.println(m.i);
    }
}


