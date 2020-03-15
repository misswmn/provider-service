package com.roncoo.eshop.juc;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-23 15:01
 */
public class SyncWaitNotify {

    public static void main(String[] args) {
        final Object o = new Object();

        char[] aI = "123456789".toCharArray();
        char[] aC = "ABCDEFGHI".toCharArray();

        new Thread(() -> {
            synchronized (o) {
                for (char c : aI) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (o) {
                for (char c : aC) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t2").start();

    }
}
