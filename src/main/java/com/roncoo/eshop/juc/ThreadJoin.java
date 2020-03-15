package com.roncoo.eshop.juc;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-23 19:59
 */
public class ThreadJoin {

    public static void main(String[] args) {
        Thread t3 = new Thread(() -> {
            System.out.println("Thread t3 ...........");
        });
        Thread t2 = new Thread(() -> {
            System.out.println("Thread t2 ...........");
            t3.start();
            try {
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t1 = new Thread(() -> {
            System.out.println("Thread t1 ...........");
            t2.start();
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
    }
}
