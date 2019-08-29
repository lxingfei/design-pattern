package com.leh.strategypattern.strategy.handler.order.service;

import com.leh.strategypattern.strategy.handler.order.model.OrderDTO;

/**
 * @Auther: leh
 * @Date: 2019/5/22 09:41
 * @Description:
 */
public class OrderServiceImpl implements IOrderService {

    @Override
    public String handle(OrderDTO order) {
        if ("1".equals(order.getType())) {

            return "普通订单";

        } else if ("2".equals(order.getType())) {

            return "团购订单";

        } else {

            return "促销订单";
        }

    }
}
