package com.leh.factorypattern.factory.simple;

import com.leh.factorypattern.factory.model.Car;

/**
 * @Auther: leh
 * @Date: 2019/8/29 10:23
 * @Description:
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        //这就相当于我们的消费者
        Car car = SimpleFactory.getInstance("AUDI");
        System.out.println(car.getName());
    }
}
