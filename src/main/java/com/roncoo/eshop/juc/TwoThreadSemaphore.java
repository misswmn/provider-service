package com.roncoo.eshop.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-24 22:35
 */
public class TwoThreadSemaphore {
    static List<Object> lists = Collections.synchronizedList(new ArrayList<>());

    public void add() {
        lists.add(new Object());
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        TwoThreadSemaphore twoThreadSemaphore = new TwoThreadSemaphore();
        Semaphore semaphore = new Semaphore(2);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                twoThreadSemaphore.add();
                System.out.println("add Obj[" + i + "]");
                if (twoThreadSemaphore.size() == 5) {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        Thread t2 = new Thread(() -> {

        });

        t1.start();
        t2.start();
    }
}
