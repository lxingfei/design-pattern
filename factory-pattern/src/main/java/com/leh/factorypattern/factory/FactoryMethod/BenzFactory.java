package com.leh.factorypattern.factory.FactoryMethod;

import com.leh.factorypattern.factory.model.BenzCar;
import com.leh.factorypattern.factory.model.Car;

/**
 * @Auther: leh
 * @Date: 2019/8/29 10:37
 * @Description:
 */
public class BenzFactory implements Factory{

    @Override
    public Car getCar() {
        return new BenzCar();
    }
}
