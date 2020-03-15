package com.roncoo.eshop.juc.c025;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-28 13:54
 */
public class LinkedBlockingQueue01 {
    static BlockingQueue<String> queue = new LinkedBlockingDeque<>();
    static Random random = new Random();

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    queue.put("a" + i);
                    System.out.println("生产者put a" + i);
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "produce1").start();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (; ; ) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " take - " + queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "consumer" + i).start();
        }
    }
}
