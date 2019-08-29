package com.leh.factorypattern.factory.AbstractFactory;

import com.leh.factorypattern.factory.model.Car;

/**
 * @Auther: leh
 * @Date: 2019/8/29 11:05
 * @Description: 假设默认生产奥迪
 */
public class DefaultFactory extends AbstractFactory{

    private AudiFactory defaultFactory = new AudiFactory();

    @Override
    public Car getCar() {
        System.out.println("excute DefaultFactory");
        return defaultFactory.getCar();
    }
}
