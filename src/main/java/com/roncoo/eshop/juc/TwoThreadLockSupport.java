package com.roncoo.eshop.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-24 21:42
 */
public class TwoThreadLockSupport {
    static List<Object> lists = Collections.synchronizedList(new ArrayList<>());
    private static Thread t1 = null;
    private static Thread t2 = null;

    public void add() {
        lists.add(new Object());
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        TwoThreadLockSupport obj = new TwoThreadLockSupport();
        t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                obj.add();
                System.out.println("add Obj[" + i + "]");
                if (obj.size() == 5) {
                    LockSupport.unpark(t2);  // 此时放开t2
                    LockSupport.park();  // 当前线程暂停  和上边一行互换？ 则无法放开t2
                }
            }
        });

        t2 = new Thread(() -> {
            if (obj.size() != 5) {
                LockSupport.park();
            }
            System.out.println("t2监控到了");
            LockSupport.unpark(t1);
        });

        t1.start();
        t2.start();
    }
}
