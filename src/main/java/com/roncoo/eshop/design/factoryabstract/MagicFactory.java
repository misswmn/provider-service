package com.roncoo.eshop.design.factoryabstract;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-29 23:22
 */
public class MagicFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
