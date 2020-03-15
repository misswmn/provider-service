package com.roncoo.eshop.juc;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-24 22:50
 */
public class TwoThread1A2B3CWaitNotify {

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 65; i < 91; i++) {
                    System.out.print((char) i);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
            System.out.println();
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i < 27; i++) {
                    System.out.print(i);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    lock.notify();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
