package com.leh.proxy.cglib;

/**
 * @Auther: leh
 * @Date: 2019/8/20 10:40
 * @Description:
 *
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        /*
        JDK的动态代理是通过接口来进行强制转换的
        生成以后的代理对象，可以强制转换为接口
        */

        /*
        CGLib的动态代理是通过生成一个被代理对象的子类，
        然后重写父类的方法生成以后的对象，
        可以强制转换为被代理对象（也就是用自己写的类）
        子类引用赋值给父类
        */
        WorkerRenter renter = (WorkerRenter) new LianHouseAgent().getInstance(WorkerRenter.class);
        renter.rentHouse();
    }
}
