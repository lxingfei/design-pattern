package com.leh.strategypattern.strategy.handler.order.concrete;

import com.leh.strategypattern.strategy.handler.order.AbstractOrderHandler;
import com.leh.strategypattern.strategy.handler.order.OrderHandlerType;
import com.leh.strategypattern.strategy.handler.order.model.OrderDTO;

/**
 * @Auther: leh
 * @Date: 2019/6/27 12:12
 * @Description:
 */
@OrderHandlerType("2")
public class NormalOrderHandler extends AbstractOrderHandler {

    @Override
    public String handler(OrderDTO order) {

        return "普通订单";
    }
}
