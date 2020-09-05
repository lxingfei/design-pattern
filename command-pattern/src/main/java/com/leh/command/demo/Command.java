package com.leh.command.demo;

/**
 * @description:
 * @author: lveh
 * @time: 2020/9/5 20:02
 */
public abstract class Command {
    private Receiver receiver;

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    abstract void excuteCommand();
}
