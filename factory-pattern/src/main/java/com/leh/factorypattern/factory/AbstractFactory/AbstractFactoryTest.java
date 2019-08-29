package com.leh.factorypattern.factory.AbstractFactory;

/**
 * @Auther: leh
 * @Date: 2019/8/29 10:46
 * @Description:
 * 设计模式的经典之处，就在于，解决了编写代码的人和调用代码的人双方的痛处,解放我们的双手
 */
public abstract class AbstractFactoryTest {

    public static void main(String[] args) {

        DefaultFactory factory = new DefaultFactory();
        System.out.println(factory.getCar().getName());
        System.out.println(factory.getCar("AUDI").getName());
        System.out.println(factory.getCar("BMW").getName());
        System.out.println(factory.getCar("BENZ").getName());
        System.out.println(factory.getCar("JEEP").getName());

    }
}
