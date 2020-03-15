package com.roncoo.eshop.juc.c025;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-28 21:09
 */
public class ConcurrentLinkedQueue01 {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
//        queue.add("aa");
//        queue.add("bb");
        String s = queue.poll();
        System.out.println(s);
    }
}
