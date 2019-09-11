package com.leh.decorator.demo;

/**
 * @Auther: leh
 * @Date: 2019/9/11 11:05
 * @Description:
 */
public class ParamXssAspect extends AbstractDecorator {

    public ParamXssAspect(IAspect aspect) {
        super(aspect);
    }

    @Override
    public String doHandlerAspect() {
        return super.doHandlerAspect() + "+ >>>>>>>>>>过滤危险字符";
    }
}
