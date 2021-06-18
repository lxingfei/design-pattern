package com.leh.proxy.jdk.permission;

/**
 * @Description
 * @Author lveh
 * @Date 2021/4/7 9:39
 * @Version 1.0
 **/
public class SaleOrderServiceImpl implements SaleOrderService{
    @Override
    public String doSomeThing(String str) {
        System.out.println(str);
        return str;
    }
}
