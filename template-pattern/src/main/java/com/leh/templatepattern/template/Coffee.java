package com.leh.templatepattern.template;

/**
 * @Auther: leh
 * @Date: 2019/8/29 16:47
 * @Description:
 */
public class Coffee extends Beverage {

    @Override
    protected void pourInCup() {
        System.out.println("准备杯子,并放入咖啡");
    }

    @Override
    protected void addCondiment() {
        System.out.println("添加辅料：牛奶和糖");
    }


}
