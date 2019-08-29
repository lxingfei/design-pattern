package com.leh.strategypattern.strategy.handler.order;


import com.leh.strategypattern.strategy.handler.order.model.OrderDTO;

/**
 * @Auther: leh
 * @Date: 2019/6/27 12:10
 * @Description:
 */
public abstract class AbstractOrderHandler {
    abstract public String handler(OrderDTO order);
}
