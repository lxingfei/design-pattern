package com.leh.factorypattern.factory.FactoryMethod;

import com.leh.factorypattern.factory.model.BmwCar;
import com.leh.factorypattern.factory.model.Car;

/**
 * @Auther: leh
 * @Date: 2019/8/29 10:37
 * @Description:
 */
public class BmwFactory implements Factory{

    @Override
    public Car getCar() {
        return new BmwCar();
    }
}
