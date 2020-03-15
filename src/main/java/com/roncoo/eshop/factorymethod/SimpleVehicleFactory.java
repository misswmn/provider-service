package com.roncoo.eshop.factorymethod;

/**
 * 简单工厂
 *
 * @description:
 * @author: wangmeng
 * @time: 2020-02-29 22:46
 */
public class SimpleVehicleFactory {
    public Car createCar() {
        return new Car();
    }

    public Broom createBroom() {
        return new Broom();
    }
}
