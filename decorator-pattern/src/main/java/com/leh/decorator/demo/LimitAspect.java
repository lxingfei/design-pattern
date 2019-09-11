package com.leh.decorator.demo;

/**
 * @Auther: leh
 * @Date: 2019/9/11 11:05
 * @Description:
 */
public class LimitAspect extends AbstractDecorator {

    public LimitAspect(IAspect aspect) {
        super(aspect);
    }

    @Override
    public String doHandlerAspect() {
        return super.doHandlerAspect() + "+ >>>>>>>>>>限流";
    }
}
