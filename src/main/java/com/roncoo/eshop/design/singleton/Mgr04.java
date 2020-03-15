package com.roncoo.eshop.design.singleton;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-29 17:47
 */
public class Mgr04 {
    private static Mgr04 instance;

    private Mgr04() {
    }

    public static synchronized Mgr04 getInstance() {
        if (instance == null) {
            instance = new Mgr04();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr04.getInstance().hashCode());
            }).start();
        }
    }
}
