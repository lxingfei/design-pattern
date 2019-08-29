package com.leh.singleton;

/**
 * 结论：由结果可以得知单例模式为一个面向对象的应用程序提供了对象惟一的访问点，
 * 不管它实现何种功能，整个应用程序都会同享一个实例对象
 */
public class TestMain {
    public static void main(String[] args){  
        TestSingleton ts1 = TestSingleton.getInstance();  
        ts1.setName("james");  
        TestSingleton ts2 = TestSingleton.getInstance();  
        ts2.setName("tom");  
          
        ts1.printInfo();  
        ts2.printInfo();

        if(ts1 == ts2){
            System.out.println("创建的是同一个实例" + ts1.getName());
        }else{
            System.out.println("创建的不是同一个实例" + ts1.getName());
        }

        /**
         *
             the name is tom
             the name is tom
             创建的是同一个实例tom
         */
    }
}