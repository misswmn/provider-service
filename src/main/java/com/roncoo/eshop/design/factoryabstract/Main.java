package com.roncoo.eshop.design.factoryabstract;

/**
 * @description:
 * @author: wangmeng
 * @time: 2020-02-29 23:06
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = new MagicFactory();
        Food food = factory.createFood();
        food.printName();

        Vehicle vehicle = factory.createVehicle();
        vehicle.go();

        Weapon weapon = factory.createWeapon();
        weapon.shoot();
    }
}
