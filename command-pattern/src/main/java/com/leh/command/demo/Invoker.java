package com.leh.command.demo;

/**
 * 核心类说明：
 * Invoker ： 请求的调用者，内部持有具体请求的引用。
 * @description:
 * @author: lveh
 * @time: 2020/9/5 20:22
 */
public class Invoker {
    private Command command;

    public void invoke(Command command){
        command.excuteCommand();
    }
}
