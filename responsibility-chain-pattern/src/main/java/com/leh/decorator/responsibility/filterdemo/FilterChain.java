package com.leh.decorator.responsibility.filterdemo;

import com.leh.decorator.responsibility.model.Request;
import com.leh.decorator.responsibility.model.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: leh
 * @Date: 2019/9/10 18:17
 * @Description:
 */
public class FilterChain implements Filter {

    //标记执行到第几个filter
    int index = 0;

    private List<Filter> filters = new ArrayList<Filter>();

    //把函数的返回值设为FilterChain，返回this,就能方便链式编写代码

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }


    @Override
    public void doFilter(Request request, Response response, FilterChain fc) {
        if (index == filters.size()) {
            return;
        }

        Filter f = filters.get(index);

        System.out.println(f.getClass().getName() + ">>>>" + index);

        index++;

        f.doFilter(request, response, fc);
    }


    /**
     *
     一、责任链模式介绍

     责任链模式定义：为请求创建一个处理此请求对象的链。

     适用场景(核心)：只要把你的请求抛给第一个处理者,不用关心谁处理的,并且最终会返回你一个结果。

     优点：请求者和处理者解耦，请求者不用知道谁处理的，处理者可以不用知道请求的全貌。

     缺点：每个请求从链头遍历到链尾，影响性能。代码调试时候不方便。

     类型：行为型。


     *
     * 源码中的典型应用：

     Netty 中的 Pipeline和ChannelHandler通过责任链设计模式来组织代码逻辑。
     Spring Security 使用责任链模式，可以动态地添加或删除责任（处理 request 请求）。ref：SPRING与设计模式---责任链模式
     Spring AOP 通过责任链模式来管理 Advisor。
     Dubbo Filter 过滤器链也是用了责任链模式（链表），可以对方法调用做一些过滤处理，譬如超时(TimeoutFilter)，异常(ExceptionFilter)，Token(TokenFilter)等。
     Mybatis 中的 Plugin 机制使用了责任链模式，配置各种官方或者自定义的 Plugin，与 Filter 类似，可以在执行 Sql 语句的时候做一些操作。
     Tomcat 调用 ApplicationFilterFactory过滤器链。
     *
     */
}
