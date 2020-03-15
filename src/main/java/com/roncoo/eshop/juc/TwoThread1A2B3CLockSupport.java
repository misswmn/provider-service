package com.roncoo.eshop.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-24 23:14
 */
public class TwoThread1A2B3CLockSupport {
    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        t1 = new Thread(() -> {
            for (int i = 65; i < 91; i++) {
                LockSupport.park();
                System.out.print((char) i);
                LockSupport.unpark(t2);
            }
            System.out.println();
        });

        t2 = new Thread(() -> {
            for (int i = 1; i < 27; i++) {
                System.out.print(i);
                LockSupport.unpark(t1);
                LockSupport.park();
            }
            LockSupport.unpark(t1);
        });

        t1.start();
        t2.start();
    }
}
