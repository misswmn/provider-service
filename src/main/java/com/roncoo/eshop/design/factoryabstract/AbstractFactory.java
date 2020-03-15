package com.roncoo.eshop.design.factoryabstract;

/**
 * 抽象工厂
 *
 * @description:
 * @author: wangmeng
 * @time: 2020-02-29 23:13
 */
public abstract class AbstractFactory {
    abstract Food createFood();

    abstract Vehicle createVehicle();

    abstract Weapon createWeapon();
}
