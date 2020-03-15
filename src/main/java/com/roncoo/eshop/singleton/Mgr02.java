package com.roncoo.eshop.singleton;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-29 17:40
 */
public class Mgr02 {
    private static Mgr02 instance;
    static {
        instance = new Mgr02();
    }
    private Mgr02() {}

    public static Mgr02 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Mgr02 inst1 = Mgr02.getInstance();
        Mgr02 inst2 = Mgr02.getInstance();
        System.out.println(inst1 == inst2);
    }
}
