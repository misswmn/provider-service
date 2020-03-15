package com.roncoo.eshop.factorymethod;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-29 22:57
 */
public class Main {
    public static void main(String[] args) {
        // 简单工厂
        Car car = new SimpleVehicleFactory().createCar();
        car.go();

        System.out.println("----------------------");
        // 工厂方法
        Moveable moveable = new CarFactory().create();
        moveable.go();
    }
}
