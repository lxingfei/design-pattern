package com.leh.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther: leh
 * @Date: 2019/8/20 10:29
 * @Description: 链家中介
 */
public class LianHouseAgent implements MethodInterceptor{

    //疑问？
    //好像并没有持有被代理对象的引用
    public Object getInstance(Class clazz){

        Enhancer enhancer = new Enhancer();

        //把父类设置为谁？
        //这一步就是告诉cglib，生成的子类需要继承哪个类
        enhancer.setSuperclass(clazz);

        //设置回调
        enhancer.setCallback(this);

        //第一步、生成源代码
        //第二步、编译成class文件
        //第三步、加载到JVM中，并返回被代理对象
        return enhancer.create();
    }

    //同样是做了字节码重组这样一件事情
    //对于使用API的用户来说，是无感知
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        System.out.println("我是链家中介：" + "帮你寻找合适的房源");
        System.out.println("开始进行匹配...");
        System.out.println("------------");

        /*
            这个obj的引用是由CGLib给我们new出来的
            cglib new出来以后的对象，是被代理对象的子类（继承了我们自己写的那个类）
            OOP, 在new子类之前，实际上默认先调用了我们super()方法的，
            new了子类的同时，必须先new出来父类，这就相当于是间接的持有了我们父类的引用
            子类重写了父类的所有的方法
            我们改变子类对象的某些属性，是可以间接的操作父类的属性的
        */
        methodProxy.invokeSuper(obj, args);

        System.out.println("------------");
        System.out.println("如果合适的话，就准备签约");

        return null;
    }
}
