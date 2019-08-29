package com.leh.factorypattern.factory.FactoryMethod;

/**
 * @Auther: leh
 * @Date: 2019/8/29 10:39
 * @Description: 工厂方法模式
 */
public class FactoryMethodTest {
    public static void main(String[] args) {

        /**
         * 各个产品的生产商，都拥有各自的工厂
         * 生产工艺，生成的高科技程度都是不一样的
         */
        Factory factory = new AudiFactory();
        System.out.println(factory.getCar().getName());

        //需要用户关心 这个产品的生产商
        factory = new BmwFactory();
        System.out.println(factory.getCar().getName());

        //增加代码的使用复杂度 进而 --》》抽象工厂模式


    }
}
