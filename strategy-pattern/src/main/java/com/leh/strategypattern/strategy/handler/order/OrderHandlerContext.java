package com.leh.strategypattern.strategy.handler.order;

import com.leh.strategypattern.strategy.handler.order.util.BeanTool;

import java.util.Map;

/**
 * @Auther: leh
 * @Date: 2019/5/22 11:34
 * @Description:
 */
public class OrderHandlerContext {
    private Map<String, Class> handlerMap;

    public OrderHandlerContext(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public AbstractOrderHandler getInstance(String type){
        Class clazz = handlerMap.get(type);
        if(clazz == null){
            throw new IllegalArgumentException("not found Class for type: " + type);
        }
        return (AbstractOrderHandler) BeanTool.getBean(clazz);

    }
}
