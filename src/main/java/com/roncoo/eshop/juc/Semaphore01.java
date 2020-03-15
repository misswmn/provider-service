package com.roncoo.eshop.juc;

import java.util.concurrent.Semaphore;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-25 21:47
 */
public class Semaphore01 {

    public static void main(String[] args) {
        //Semaphore s = new Semaphore(2);
        Semaphore s = new Semaphore(1, true);
        //允许一个线程同时执行
        //Semaphore s = new Semaphore(1);

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    s.acquire();

                    System.out.println(Thread.currentThread().getName() + " start running...");
                    Thread.sleep(200);
                    System.out.println(Thread.currentThread().getName() + " end running...");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    s.release();
                }
            }).start();

            new Thread(() -> {
                try {
                    s.acquire();

                    System.out.println(Thread.currentThread().getName() + " start running...");
                    Thread.sleep(200);
                    System.out.println(Thread.currentThread().getName() + " end running...");

                    s.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
