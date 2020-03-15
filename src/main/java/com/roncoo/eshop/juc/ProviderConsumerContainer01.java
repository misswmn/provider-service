package com.roncoo.eshop.juc;

import java.util.LinkedList;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-24 23:49
 */
public class ProviderConsumerContainer01<T> {
    LinkedList<T> lists = new LinkedList<>();
    static int max = 10;
    private int count;

    public synchronized void put(T t) {
        while (lists.size() == max) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lists.add(t);
        ++count;
        this.notifyAll();
    }

    public synchronized T get() {
        while (lists.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = lists.removeFirst();
        --count;
        this.notifyAll();
        return t;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        ProviderConsumerContainer01<String> obj = new ProviderConsumerContainer01<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(obj.get());
                }
            }, "consumer" + i).start();

        }

        for (int i = 0; i < 2; i++) {
            new Thread(() ->{
                for (int j = 0; j < 25; j++) {
                    obj.put(Thread.currentThread().getName() + " " + j);
                }
            }, "produce" + i).start();
        }

    }
}
