package com.roncoo.eshop.design.factoryabstract;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-29 23:21
 */
public class ModernFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
