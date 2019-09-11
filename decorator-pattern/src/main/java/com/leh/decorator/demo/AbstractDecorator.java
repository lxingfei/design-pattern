package com.leh.decorator.demo;

/**
 * @Auther: leh
 * @Date: 2019/9/11 11:03
 * @Description:
 */
public class AbstractDecorator implements IAspect {

    //很重要,组合抽象构件到自己的类中
    private IAspect aspect;

    //通过IAspect构造自己
    public AbstractDecorator(IAspect aspect) {
        this.aspect = aspect;
    }

    @Override
    public String doHandlerAspect() {
        return this.aspect.doHandlerAspect();
    }

    /*
        一、饰器者模式介绍

        装饰者模式定义：在不改变原有对象的基础上附加功能，相比生成子类更灵活。

        适用场景：动态的给一个对象添加或者撤销功能。

        优点：可以不改变原有对象的情况下动态扩展功能，可以使扩展的多个功能按想要的顺序执行，以实现不同效果。

        缺点：更多的类，使程序复杂

        类型：结构型。


        源码分析中的典型应用

        Java IO中是体现最明显的装饰者模式
        Spring Session 中的装饰者模式
        Mybatis 缓存中的装饰者模式

     */


}
