package com.leh.strategy;

import com.leh.strategypattern.strategy.handler.order.model.OrderDTO;
import com.leh.strategypattern.strategy.handler.order.service.OrderServiceV2Impl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Auther: leh
 * @Date: 2019/5/22 11:53
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {

    @Resource
    private OrderServiceV2Impl orderServiceV2;

    @Test
    public void test(){
        OrderDTO dto = new OrderDTO();
        dto.setType("1");
        dto.setPrice(new BigDecimal("100"));
        orderServiceV2.handle(dto);
    }



}
