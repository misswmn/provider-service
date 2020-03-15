package com.roncoo.eshop.juc.c025;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-28 15:09
 */
public class ArrayBlockingQueue01 {
    static ArrayBlockingQueue<String> putQueue = new ArrayBlockingQueue<>(4);
    static ArrayBlockingQueue<String> getQueue = new ArrayBlockingQueue<>(4);

    static {
        try {
            putQueue.put("a1");
            putQueue.put("a2");
            putQueue.put("a4");
            putQueue.put("a3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void add() throws InterruptedException {
//        boolean added = queue.add("a5"); // 满了抛异常
//        System.out.println(added);

//        boolean added02= queue.offer("a5"); // 满了返回false
//        System.out.println(added02);

        boolean added03 = putQueue.offer("a5", 5, TimeUnit.SECONDS); // 等待5秒之后返回添加结果 false
        System.out.println(added03);

    }

    static void get() throws InterruptedException {
//        String result1 = getQueue.take(); // 获取不到元素一直等待
//        System.out.println(result1);

//        String result2 = getQueue.poll(); // 获取不到元素返回Null
//        System.out.println(result2);

//        String result3 = getQueue.peek(); // 获取不到元素返回Null
//        System.out.println(result3);

        String result4 = getQueue.poll(5, TimeUnit.SECONDS); // 等待5秒之后返回获取到的 null
        System.out.println(result4);

    }

    public static void main(String[] args) throws InterruptedException {
//        add();
        get();
    }
}
