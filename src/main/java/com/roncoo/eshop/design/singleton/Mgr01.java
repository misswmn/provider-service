package com.roncoo.eshop.design.singleton;

/**
 * 饿汉式
 * 类加载到内存后，实例化一个单例,JVM保证线程安全
 * 缺点：无论是否用到，类装载时就实例化
 *
 * @description:
 * @author: wangmeng
 * @time: 2020-02-29 17:34
 */
public class Mgr01 {
    private final static Mgr01 instance = new Mgr01();

    private Mgr01() {
    }

    public static Mgr01 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Mgr01 inst1 = Mgr01.getInstance();
        Mgr01 inst2 = Mgr01.getInstance();
        System.out.println(inst1 == inst2);
    }
}
