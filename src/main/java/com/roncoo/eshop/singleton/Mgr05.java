package com.roncoo.eshop.singleton;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-29 17:49
 */
public class Mgr05 {
    private static Mgr05 instance;

    private Mgr05() {
    }

    public static Mgr05 getInstance() {
        if (instance == null) {
            // 此处线程不安全
            synchronized (Mgr05.class) {
                try {
                    TimeUnit.MILLISECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance = new Mgr05();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr05.getInstance().hashCode());
            }).start();
        }
    }
}
