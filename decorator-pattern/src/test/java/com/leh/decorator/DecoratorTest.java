package com.leh.decorator;

import com.leh.decorator.demo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: leh
 * @Date: 2019/9/11 11:08
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DecoratorTest {

    @Test
    public void decorator(){
        IAspect aspect = new LimitAspect(new ParamXssAspect(new LoggerAspect(new AspectImpl())));

        System.out.println(aspect.doHandlerAspect());

        /*
            output:
            执行业务代码+ >>>>>>>>>>记录日志+ >>>>>>>>>>过滤危险字符+ >>>>>>>>>>限流
         */
    }


}
