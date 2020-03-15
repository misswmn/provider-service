package com.roncoo.eshop.juc.c023;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-27 22:50
 */
public class LinkedList01 {


    static List<String> tickets = new LinkedList<>();


    static {
        for (int i = 1; i <= 200; i++) tickets.add("票 编号：" + i);
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    synchronized (tickets) {
                        if (tickets.size() <= 0) break;

                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("销售了--" + tickets.remove(0));
                    }
                }
            }).start();
        }
    }
}
