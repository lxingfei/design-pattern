package com.leh.delegatepattern.delegate;

/**
 * @Auther: leh
 * @Date: 2019/6/19 15:46
 * @Description:
 */
public class ExecutorB implements IExecutor {

    @Override
    public void doing() {
        System.out.println("员工执行任务");
    }
}
