package com.leh.templatepattern.template;

/**
 * @Auther: leh
 * @Date: 2019/8/29 16:45
 * @Description:
 */
public class Tea extends Beverage {

    /**
     * 添加辅料
     */
    @Override
    protected void addCondiment() {
        System.out.println("添加辅料：蜂蜜");
    }

    /**
     * 原材料放到杯中
     */
    @Override
    protected void pourInCup() {
        System.out.println("准备杯子，并放入茶叶");
    }
}
