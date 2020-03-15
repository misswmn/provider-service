package com.roncoo.eshop.singleton;

/**
 * 枚举方式
 * 优点：防止反序列化，线程同步
 *
 * @description:
 * @author: wangmeng
 * @time: 2020-02-29 18:04
 */
public enum Mgr08 {
    INSTANCE;

    public void m() {
        System.out.println("m method ....");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr08.INSTANCE.hashCode());
            }).start();
        }
    }
}
