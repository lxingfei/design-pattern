package com.leh.templatepattern.bankbiz;

/**
 * @Description
 * @Author lveh
 * @Date 2021/3/15 14:16
 * @Version 1.0
 * 1、模板方法模式
 * 模板方法模式很常用，其目的是在一个方法中定义一个算法骨架，而将一些步骤延迟到子类中。
 * 模板方法使得子类可以在不改变算法结构的情况下，重新定义算法的某些步骤。
 * 在标准的模板方法模式实现中，主要是使用继承的方式，来让父类在运行期间可以调用到子类的方法。
 * 即：处理某个流程的代码已经都具备，但是其中某个节点的代码暂时不能确定。
 * 处理步骤在父类中定义好，具体实现延迟到子类中定义 。
 * <p>
 * 2、回调机制（钩子方法）
 * Don’t call me ,we’ll call you back.
 * 找工作的人把简历投递到 XX 公司，所能做的就是等待，整个过程由公司控制，
 * 找工作的人只能等待（公司打电话通知面试……）
 * 在软件开发中，我们可以将 call 翻译为调用，子类（找工作的人）不能调用父类（XX 公司），
 * 而是通过父类调用子类。这些调用步骤已经在父类中写好了，完全由父类控制整个过程。
 **/
abstract class BankTemplateMethod {
    /*
     * 应用场景：
     * 客户到银行办理业务
     *  (1) 取号排队
        (2) 办理具体现金/转账/企业/个人/理财业务
        (3) 给银行工作人员评分
     **/
    protected void takeNumber() {
        System.out.println("排队取号...");
    }

    protected abstract void transact();//办理业务的方法由子类具体实现

    protected void evaluate() {
        System.out.println("给业务员评分...");
    }

    //办理业务的流程---（1）取号 （2）办理业务	（3）评分
    public final void process() {
        takeNumber();
        transact();
        evaluate();
    }

}
