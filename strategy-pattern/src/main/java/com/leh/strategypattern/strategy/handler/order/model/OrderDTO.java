package com.leh.strategypattern.strategy.handler.order.model;

import java.math.BigDecimal;

/**
 * @Auther: leh
 * @Date: 2019/5/22 09:40
 * @Description:
 */
public class OrderDTO {

    private String code;

    private String type;

    private BigDecimal price;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
