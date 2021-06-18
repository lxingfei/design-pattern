package com.leh.templatepattern.bankbiz;

/**
 * @Description
 * @Author lveh
 * @Date 2021/3/15 14:22
 * @Version 1.0
 **/
public class Deposit extends BankTemplateMethod{
    @Override
    protected void transact() {
        System.out.println("办理存款业务...");
    }
}
