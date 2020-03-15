package com.roncoo.eshop.juc.c025;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-28 13:24
 */
public class ThreadPool01 {
    static class  Task implements Runnable {
        private  int i;
        public Task(int i) {
            this.i = i;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Task " + i);
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "Task{" +
                    "i=" + i +
                    '}';
        }
    }
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 8; i++) {
            threadPoolExecutor.execute(new Task(i));
            threadPoolExecutor.submit(()->{

            });
        }

        System.out.println(threadPoolExecutor.getQueue());
        threadPoolExecutor.shutdown();
    }
}
