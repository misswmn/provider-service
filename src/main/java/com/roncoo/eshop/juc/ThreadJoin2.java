package com.roncoo.eshop.juc;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-23 19:59
 */
public class ThreadJoin2 {

    public static void main(String[] args) {

        int index=65;
        Thread t2 = new Thread(() -> {
            for (int i = 65; i < 91; i++) {
                System.out.print((char) i);
            }
        });

        Thread t1 = new Thread(() -> {
            for (int i = 1; i < 27; i++) {
                System.out.print(i);
                try {
                    if(i==1) {

                        t2.start();
                    }
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
    }
}
