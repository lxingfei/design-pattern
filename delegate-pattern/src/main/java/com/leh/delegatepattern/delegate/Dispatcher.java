package com.leh.delegatepattern.delegate;

/**
 * @Auther: leh
 * @Date: 2019/6/19 15:50
 * @Description:委派模式 三个条件：
 * 1  委托人  受托人 （执行者）
 * 2. 委托人持有受托人的引用 （区别代理模式 - 执行者持有被代理人的引用）
 * 3. 只关心结果不关心过程 （区别代理模式 - 关心过程）
 */
public class Dispatcher implements IExecutor {

    private IExecutor executor;

    public Dispatcher(IExecutor executor) {
        this.executor = executor;
    }

    /**
     * 项目经理也有执行方法，但是他的工作职责是不一样的
     */
    @Override
    public void doing() {
        this.executor.doing();
    }
}
