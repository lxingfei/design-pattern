package com.leh.delegatepattern.delegate;

/**
 * @Auther: leh
 * @Date: 2019/6/19 15:46
 * @Description:
 */
public class ExecutorA implements IExecutor {

    @Override
    public void doing() {
        System.out.println("员工A执行任务");
    }
}
