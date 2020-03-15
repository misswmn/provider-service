package com.roncoo.eshop.collection;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-03-11 19:56
 */
public class CopyOnWriteTest {

    public static void main(String[] args) {
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        list.add(11);
        list.add(122);
        System.out.println();
    }
}
