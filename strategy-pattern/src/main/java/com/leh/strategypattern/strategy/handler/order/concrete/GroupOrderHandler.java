package com.leh.strategypattern.strategy.handler.order.concrete;

import com.leh.strategypattern.strategy.handler.order.AbstractOrderHandler;
import com.leh.strategypattern.strategy.handler.order.OrderHandlerType;
import com.leh.strategypattern.strategy.handler.order.model.OrderDTO;
import org.springframework.stereotype.Component;

/**
 * @Auther:
 * @Description:
 */
@Component
@OrderHandlerType("1")
public class GroupOrderHandler extends AbstractOrderHandler {

    @Override
    public String handler(OrderDTO order) {
        return "团购订单";
    }
}
