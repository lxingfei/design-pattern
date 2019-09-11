package com.leh.decorator.question;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: leh
 * @Date: 2019/9/11 10:46
 * @Description:给系统添加日志，安全、限流示例
 * @see <a herf="https://my.oschina.net/liughDevelop/blog/2987320"></a>
 */
public abstract class BaseAspect {

    Logger logger = LoggerFactory.getLogger(BaseAspect.class);

    public void execute() {
        //记录日志
        logger.debug("..start..");

        //过滤跨站脚本攻击
        paramXssAspect();

        //限制速率
        doRateLimit();

        doBusiness();

        logger.debug("..end..");
    }

    protected void doRateLimit() {
        System.out.println("执行 限流 逻辑");
    }

    protected void paramXssAspect(){
        System.out.println("执行 过滤跨站脚本攻击 逻辑");
    }


    public abstract void doBusiness();



     /*

        一般系统的安全、日志、限流等业务无关代码可以抽离出来，
        在Controller前后用切面改造，模板方法模式可以部分解决这个问题；

        优点：
        在父类中已经把”乱七八糟“的非业务代码写好了，只留了一个抽象方法等子类去实现，
        子类变的很清爽，只需关注业务逻辑就可以了

        缺点：
        这种方式最大的缺陷就是父类会定义一切：要执行那些非业务代码，以什么顺序执行等等，子类只能无条件接受。
        如果有一个子类，不限制速率，那么它也没有办法把它去掉

        解决方式：装饰者模式
      */

}
