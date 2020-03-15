package com.roncoo.eshop.juc.c025;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-28 17:25
 */
public class ExecutorService01 {
    private static Random random = new Random();

    public static void singleThreadThreadExecutor() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int j = i;
            executorService.execute(() -> {
                System.out.println(j + " " + Thread.currentThread().getName());
                try {
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
    }

    public static void fixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            final int j = i;
            executorService.execute(() -> {
                System.out.println(j + "" + Thread.currentThread().getName());
                try {
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void rt() {
        int COUNT_BITS = Integer.SIZE - 3;
        int RUNNING = 3 << COUNT_BITS;
        System.out.println(COUNT_BITS);
        System.out.println(RUNNING);
    }

    public static void cachedThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
    }

    public static void main(String[] args) {
//        fixedThreadPool();
        rt();
    }
}
