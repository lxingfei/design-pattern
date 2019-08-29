package com.leh.strategypattern.strategy.handler.order.concrete;

import com.leh.strategypattern.strategy.handler.order.AbstractOrderHandler;
import com.leh.strategypattern.strategy.handler.order.OrderHandlerType;
import com.leh.strategypattern.strategy.handler.order.model.OrderDTO;

/**
 * @Auther: leh
 * @Date: 2019/6/27 12:12
 * @Description:
 */
@OrderHandlerType("3")
public class PromotionOrderHandler extends AbstractOrderHandler {

    @Override
    public String handler(OrderDTO order) {

        return "促销订单";
    }
}
