package com.leh.templatepattern.template;

/**
 * @Auther: leh
 * @Date: 2019/8/29 16:38
 * @Description: 制作饮料
 */
public abstract class Beverage {

    /**
     * 工艺流程不能变 不能被重写 --》 final
     */
    public final void create(){
        // 1 烧水
        boilWater();

        // 2 准备杯子 原料放入杯中
        pourInCup();

        // 3 加水冲泡
        brew();

        // 4 添加辅料
        addCondiment();
    }

    protected abstract void addCondiment();

    protected abstract void pourInCup();

    protected void brew(){
        System.out.println("将开水放入杯中进行冲泡");
    }

    protected void boilWater(){
        System.out.println("烧开水，烧到100度可以起锅了");
    }


}
