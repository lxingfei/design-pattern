package com.leh.factorypattern.factory.AbstractFactory;

import com.leh.factorypattern.factory.model.AudiCar;
import com.leh.factorypattern.factory.model.Car;

/**
 * @Auther: leh
 * @Date: 2019/8/29 10:37
 * @Description:
 */
public class AudiFactory extends AbstractFactory{

    @Override
    public Car getCar() {
        return new AudiCar();
    }
}
