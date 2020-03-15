package com.roncoo.eshop.juc.c025;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-28 17:04
 */
public class LinkedBlockingQueue02 {
    static LinkedBlockingQueue putQueue = new LinkedBlockingQueue();
    static LinkedBlockingQueue gettQueue = new LinkedBlockingQueue();

    public static void add() {
        putQueue.add("");
    }

    public static void main(String[] args) {

    }
}
