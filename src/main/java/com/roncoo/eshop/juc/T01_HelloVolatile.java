package com.roncoo.eshop.juc;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-23 23:14
 */
public class T01_HelloVolatile {
    volatile boolean running = true; //对比一下有无volatile的情况下，整个程序运行结果的区别

    void m() {
        System.out.println("m start");
        while (running) {
        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {
        T01_HelloVolatile t = new T01_HelloVolatile();

        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running = false;
    }

}
