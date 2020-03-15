package com.roncoo.eshop.design.factorymethod;

/**
 * 工厂方法
 *
 * @description:
 * @author: wangmeng
 * @time: 2020-02-29 22:54
 */
public class CarFactory {
    public Moveable create() {
        System.out.println("create car ......");
        return new Car();
    }
}
