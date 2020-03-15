package com.roncoo.eshop.factorymethod;

/**
 * 工厂方法
 *
 * @description:
 * @author: wangmeng
 * @time: 2020-02-29 22:54
 */
public class PlaneFactory {
    public Moveable create() {
        System.out.println("create plane ......");
        return new Plane();
    }
}
