package com.roncoo.eshop.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-25 20:36
 */
public class CountDownLatch01 {

    public static void main(String[] args) {
//        usingJoin();
        usingCountDownLatch();
    }

    private static void usingCountDownLatch() {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                int result = 0;
                for (int j = 0; j < 10000; j++) result += j;
                latch.countDown();
                System.out.println("-1");
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        try {
            latch.await();
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end latch");
    }

    private static void usingJoin() {
        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                int result = 0;
                for (int j = 0; j < 10000; j++) result += j;
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("end join");
    }
}
