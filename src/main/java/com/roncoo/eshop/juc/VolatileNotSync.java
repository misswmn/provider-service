package com.roncoo.eshop.juc;
/**
 * volatile²¢²»ÄÜ±£Ö¤¶à¸öÏß³Ì¹²Í¬ÐÞ¸Ärunning±äÁ¿Ê±Ëù´øÀ´µÄ²»Ò»ÖÂÎÊÌâ£¬Ò²¾ÍÊÇËµvolatile²»ÄÜÌæ´úsynchronized
 * ÔËÐÐÏÂÃæµÄ³ÌÐò£¬²¢·ÖÎö½á¹û
 *
 * @author mashibing
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-25 19:15
 */
public class VolatileNotSync {


    volatile int count = 0;

    void m() {
        for (int i = 0; i < 10000; i++) count++;
    }

    public static void main(String[] args) {
        VolatileNotSync t = new VolatileNotSync();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-" + i));
        }

        threads.forEach((o) -> o.start());

        threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);


    }


}
