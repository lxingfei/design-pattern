package com.leh.templatepattern.bankbiz;

/**
 * @Description 模板 + 回调 实现
 * @Author lveh
 * @Date 2021/3/15 14:23
 * @Version 1.0
 **/
public class TestCallBack {
    public static void main(String[] args) {
        BankTemplateMethod deposit = new Deposit();
        deposit.process();
        System.out.println("-------------------------------");
        //内部类实现
        BankTemplateMethod withdrawal = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("办理取款业务...");
            }
        };
        withdrawal.process();
        System.out.println("-------------------------------");
        BankTemplateMethod transferAccounts = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("办理转账业务...");
            }
        };
        transferAccounts.process();
    }

    /*    通过回调在接口中定义的方法，调用到具体的实现类中的方法，
          其本质是利用Java的动态绑定技术，
          在这种实现中，可以不把实现类写成单独的类，
          而使用内部类或匿名内部类来实现回调方法。
    */
}
