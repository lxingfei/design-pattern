package com.leh.decorator.responsibility.handlerdemo;

import com.leh.decorator.responsibility.model.LeaveRequest;

/**
 * @see <a herf="https://my.oschina.net/liughDevelop/blog/2980567">责任链</a>
 * @Auther: leh
 * @Date: 2019/9/11 09:50
 * @Description:
 * 抽象处理者类 AbstractApproveHandler，维护一个nextHandler属性，该属性为当前处理者的下一个处理者的引用；
 * 声明了抽象方法process，其实在这里也用了方法模板模式：
 */
public abstract class AbstractApproveHandler {

    //下一个处理者(与类一致,这段代码很重要)
    protected AbstractApproveHandler nextHandler;

    public void setNextHandler(AbstractApproveHandler handler){
        this.nextHandler = handler;
    }

    // 处理请假(这里用了模板方法模式)
    public abstract void process(LeaveRequest request);


}
