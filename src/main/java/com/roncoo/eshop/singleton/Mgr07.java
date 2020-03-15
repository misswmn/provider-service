package com.roncoo.eshop.singleton;

/**
 * 静态内部类方式
 * 优点：懒汉式
 *
 * @description:
 * @author: wangmeng
 * @time: 2020-02-29 17:49
 */
public class Mgr07 {

    private Mgr07() {
    }

    private static class Mgr07Holder {
        private static final Mgr07 instance = new Mgr07();
    }

    public static Mgr07 getInstance() {
        return Mgr07Holder.instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr07.getInstance().hashCode());
            }).start();
        }
    }
}
