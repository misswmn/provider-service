package com.roncoo.eshop.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-25 20:22
 */
public class ReentrantLock01 extends Thread{
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(lock.isLocked());
            lock.lock();
            try {

                System.out.println(Thread.currentThread().getName() + "获得锁");
            }finally {
//                lock.getQueueLength();
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) {

        Thread t1 = new ReentrantLock01();
        Thread t2 = new ReentrantLock01();
        t1.start();
        try {
            TimeUnit.NANOSECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
