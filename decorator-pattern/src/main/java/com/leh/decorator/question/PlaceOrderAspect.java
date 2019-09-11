package com.leh.decorator.question;

/**
 * @Auther: leh
 * @Date: 2019/9/11 10:56
 * @Description:
 */
public class PlaceOrderAspect extends BaseAspect{

    @Override
    public void doBusiness() {
        System.out.println("下单操作");
    }
}
