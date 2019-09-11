package com.leh.chain.filter;

import com.leh.chain.responsibility.filterdemo.FilterChain;
import com.leh.chain.responsibility.filterdemo.HTMLFilter;
import com.leh.chain.responsibility.filterdemo.SensitiveFilter;
import com.leh.chain.responsibility.model.Request;
import com.leh.chain.responsibility.model.Response;

/**
 * @Auther: leh
 * @Date: 2019/9/10 18:26
 * @Description: 责任链模式：
 * 数据消息在进入数据库之前，要被多种过滤规则进行处理，多种规则形成一种链，依次处理
 * 给定的数据消息
 */

public class FilterTest {
    public static void main(String[] args) {
        //设定过滤规则，对 msg字符串进行过滤处理
        String msg = "测试责任链***************FUCK******************模式";
        //过滤请求
        Request request = new Request();
        //set方法，将待处理字符串传递进去
        request.setRequestStr(msg);
        //处理过程结束，给出的响应
        Response response = new Response();
        //设置响应信息
        response.setResponseStr("response:");

        //FilterChain,过滤规则形成的拦截链条
        FilterChain fc = new FilterChain();

        //规则链条添加过滤规则，采用的是链式调用
        fc.addFilter(new HTMLFilter())
                .addFilter(new SensitiveFilter());

        //按照FilterChain的规则顺序，依次应用过滤规则
        fc.doFilter(request, response, fc);

        //打印请求信息
        System.out.println(request.getRequestStr());

        //打印响应信息
        System.out.println(response.getResponseStr());

        /*
         * 处理器对数据进行处理
         * --|----|---数据--|-----|---
         * 规则1      规则2                 规则3       规则4
         */
    }
}
