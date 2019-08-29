package com.leh.factorypattern.factory.AbstractFactory;

import com.leh.factorypattern.factory.FactoryMethod.AudiFactory;
import com.leh.factorypattern.factory.FactoryMethod.BenzFactory;
import com.leh.factorypattern.factory.FactoryMethod.BmwFactory;
import com.leh.factorypattern.factory.model.Car;

/**
 * @Auther: leh
 * @Date: 2019/8/29 10:46
 * @Description:
 */
public abstract class AbstractFactory{

    protected abstract Car getCar();

    /**
     * 这段代码就是动态配置的功能
     * 固定模式的委派
     */
    public Car getCar(String name) {
        switch (name) {
            case "AUDI":
                return new AudiFactory().getCar();
            case "BMW":
                return new BmwFactory().getCar();
            case "BENZ":
                return new BenzFactory().getCar();
            default:
                System.out.println("这个产品产不出来");
                return null;
        }
    }
}
