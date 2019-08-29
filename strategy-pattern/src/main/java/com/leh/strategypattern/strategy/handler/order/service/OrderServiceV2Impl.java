package com.leh.strategypattern.strategy.handler.order.service;

import com.leh.strategypattern.strategy.handler.order.AbstractOrderHandler;
import com.leh.strategypattern.strategy.handler.order.OrderHandlerContext;
import com.leh.strategypattern.strategy.handler.order.model.OrderDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: leh
 * @Date: 2019/5/22 09:47
 * @Description:
 */

@Service("orderServiceV2")
public class OrderServiceV2Impl implements IOrderService{

    @Resource
    private OrderHandlerContext context;

    @Override
    public String handle(OrderDTO order) {
        AbstractOrderHandler handler = context.getInstance(order.getType());
        return handler.handler(order);
    }
}
