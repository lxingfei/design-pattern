package com.leh.strategypattern.strategy.handler.order.service;

import com.leh.strategypattern.strategy.handler.order.model.OrderDTO;

/**
 * @Auther: leh
 * @Date: 2019/5/22 09:40
 * @Description:
 */
public interface IOrderService {

    String handle(OrderDTO order);

}
