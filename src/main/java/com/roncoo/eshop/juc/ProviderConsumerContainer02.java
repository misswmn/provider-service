package com.roncoo.eshop.juc;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-26 20:12
 */
public class ProviderConsumerContainer02<T> {
    LinkedList<T> lists = new LinkedList<>();
    static int max = 10;
    private int count;

    private ReentrantLock lock = new ReentrantLock();
    private Condition consumer = lock.newCondition();
    private Condition producer = lock.newCondition();

    public void put(T t) {
        try {
            lock.lock();
            while (lists.size() == max) {
                producer.await();
            }
            lists.add(t);
            ++count;
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get() {
        T t = null;
        try {
            lock.lock();
            while (lists.size() == 0) {
                consumer.await();
            }
            t = lists.removeFirst();
            count--;
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        ProviderConsumerContainer02<String> obj = new ProviderConsumerContainer02<>();
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
