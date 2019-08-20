package com.leh.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: leh
 * @Date: 2019/8/20 09:52
 * @Description: 中介
 */
public class Agent implements InvocationHandler{

    private Renter target;//被代理对象的引用作为一个成员变量保存下来了

    //获取被代理人的个人资料
    public Object getInstance(Renter target){
        this.target = target;
        Class clazz = target.getClass();
        System.out.println("被代理对象的class是:"+clazz);
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("我是中介：" + "帮你寻找合适的房源");
        System.out.println("开始进行匹配...");
        System.out.println("------------");
        method.invoke(this.target, args);

        System.out.println("------------");
        System.out.println("如果合适的话，就准备签约");
        return null;
    }
}
