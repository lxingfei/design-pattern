package com.leh.command.demo;

/**
 * 封装的请求对象，内部持有Receiver对象。
 * @description:
 * @author: lveh
 * @time: 2020/9/5 20:02
 */
public class DelCommand extends Command{
    public DelCommand() {
        super();
        super.setReceiver(new Receiver());
    }
    @Override
    void excuteCommand() {
        getReceiver().del();
    }
}
