package com.leh.decorator.demo;

/**
 * @Auther: leh
 * @Date: 2019/9/11 11:02
 * @Description:
 */
public class AspectImpl implements IAspect{

    @Override
    public String doHandlerAspect() {
        return "执行业务代码";
    }
}
