package com.leh.proxy.jdk.permission;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author lveh
 * @Date 2021/4/7 9:42
 * @Version 1.0
 **/
public class PermissionAspect implements InvocationHandler {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class clazz = target.getClass();
        System.out.println("被代理对象的class是:" + clazz);
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    public static void init() {
        Field[] fields = PermissionAspect.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            PermissionCheckAnno permissionCheckAnno = fields[i].getType().getAnnotation(PermissionCheckAnno.class);
            if (permissionCheckAnno != null) {
                fields[i].setAccessible(true);
                try {
                    PermissionAspect permissionAspect = new PermissionAspect();
                    fields[i].set(permissionAspect, permissionAspect.getInstance(fields[i].get(permissionAspect)));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(method, args);
        Object result = null;
        result = method.invoke(target, args);
        after(result);
        return null;
    }

    public void before(Method method, Object[] args) {
        System.out.println("~~~~ before: " + method.getName() + " " + args);
    }

    public void after(Object object) {
        System.out.println("~~~~ after: " + object);
    }


    public static SaleOrderService saleOrderService = new SaleOrderServiceImpl();

    public static void main(String[] args) {
        init();
        saleOrderService.doSomeThing("I'm SaleOrderServiceImpl");
    }
}
