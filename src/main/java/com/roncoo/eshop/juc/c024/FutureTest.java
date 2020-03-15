package com.roncoo.eshop.juc.c024;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-28 00:01
 */
public class FutureTest {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(()->{
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.println("10086");
            return 10086;
        });
        new Thread(futureTask).start();



        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future future =  executorService.submit(futureTask);
//        try {
//            System.out.println(futureTask.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
