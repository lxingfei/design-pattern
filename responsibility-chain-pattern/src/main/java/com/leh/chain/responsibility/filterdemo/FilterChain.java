package com.leh.chain.responsibility.filterdemo;

import com.leh.chain.responsibility.model.Request;
import com.leh.chain.responsibility.model.Response;

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
