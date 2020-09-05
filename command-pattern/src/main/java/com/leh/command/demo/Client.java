package com.leh.command.demo;

/**
 * 核心类说明：
 * Client ： 即请求发出者，通过调用Invoker方法发出请求。
 * @description:
 * @author: lveh
 * @time: 2020/9/5 20:23
 */
public class Client {
    public static void main(String[] args) {
        Command command1 = new InsertCommand();
        Command command2 = new DelCommand();
        Invoker invoker = new Invoker();
        invoker.invoke(command1);
        invoker.invoke(command2);
    }
}
