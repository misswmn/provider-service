package com.roncoo.eshop.gc;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-03-09 17:43
 */
public class DeadLockTest {
    private static Object lockA = new Object();
    private static Object lockB = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lockA) {
                System.out.println("get lockA start...");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lockB) {
                    System.out.println("get lockB start...");
                }
                System.out.println("get lockA end...");
            }
        }).start();

        new Thread(() -> {
            synchronized (lockB) {
                System.out.println("get lockB start >>>>>");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lockA) {
                    System.out.println("get lockA start >>>");
                }
                System.out.println("get lockB end >>>>");
            }
        }).start();
    }
}
