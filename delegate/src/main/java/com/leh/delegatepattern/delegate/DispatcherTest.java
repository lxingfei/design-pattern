package com.leh.delegatepattern.delegate;

/**
 * @Auther: leh
 * @Date: 2019/6/19 16:08
 * @Description:
 */
public class DispatcherTest {

    public static void main(String[] args) {
        new Dispatcher(new ExecutorA()).doing();
    }
}
