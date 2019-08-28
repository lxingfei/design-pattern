package com.leh.singleton.multiway;

/**
 * @Auther: leh
 * @Date: 2019/8/27 15:33
 * @Description: 饿汉式单例类.在类初始化时，已经自行实例化
 * 饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的
 */
public class SingletonHungry {

    //2、声明静态变量，在类实例化之前就初始化变量,将对象引用保存
    private static SingletonHungry instance = new SingletonHungry();

    //1、 同样也是将默认构造方法私有化
    private SingletonHungry() {
    }

    //3、开放静态方法，获取实例
    public static SingletonHungry getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        SingletonHungry hungry1 = SingletonHungry.getInstance();
        SingletonHungry hungry2 = SingletonHungry.getInstance();
        System.out.println(hungry1 == hungry2);//true
    }
}
