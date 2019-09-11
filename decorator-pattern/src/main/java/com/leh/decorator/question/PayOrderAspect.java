package com.leh.decorator.question;

/**
 * @Auther: leh
 * @Date: 2019/9/11 10:56
 * @Description:
 */
public class PayOrderAspect extends BaseAspect{

    @Override
    public void doBusiness() {
        System.out.println("支付操作");
    }
}
