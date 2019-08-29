package com.leh.strategypattern.strategy.handler.order;

import java.lang.annotation.*;

/**
 * @Auther: leh
 * @Date: 2019/5/22 09:52
 * @Description:
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface OrderHandlerType {

    String value();
}
