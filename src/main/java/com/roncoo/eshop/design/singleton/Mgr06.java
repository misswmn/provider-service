package com.roncoo.eshop.design.singleton;

import java.util.concurrent.TimeUnit;

/**
 * DCL 双重检查 需要加volatile 禁止指令重排序
 *
 * @description:
 * @author: wangmeng
 * @time: 2020-02-29 17:49
 */
public class Mgr06 {
    private static volatile Mgr06 instance;

    private Mgr06() {
    }

    public static Mgr06 getInstance() {
        // 不需要加多余的锁
        if (instance == null) {
            synchronized (Mgr06.class) {
                // 双重检查
                if (instance == null) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Mgr06();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr06.getInstance().hashCode());
            }).start();
        }
    }
}
