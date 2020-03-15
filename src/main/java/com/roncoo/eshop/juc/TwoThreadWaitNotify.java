package com.roncoo.eshop.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-24 21:16
 */
public class TwoThreadWaitNotify {
    static List<Object> lists = Collections.synchronizedList(new ArrayList<>());

    public void add() {
        lists.add(new Object());
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        TwoThreadWaitNotify obj = new TwoThreadWaitNotify();
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    obj.add();
                    System.out.println("add Obj[" + i + "]");
                    if (obj.size() == 5) {
                        lock.notify(); // 2. 叫醒t2
                        try {
                            lock.wait(); // 3. 释放锁，先不要添加了
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }


            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    if (obj.size() != 5) {
                        lock.wait(); // 1. 直接wait  让出锁
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2监控到了");
                lock.notify();
            }
        });

        t1.start();
        t2.start();
    }
}
