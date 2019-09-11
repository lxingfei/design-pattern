package com.leh.chain.responsibility.filterdemo;

import com.leh.chain.responsibility.model.Request;
import com.leh.chain.responsibility.model.Response;

/**
 * @Auther: leh
 * @Date: 2019/9/10 18:23
 * @Description: html符号过滤
 */
public class HTMLFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("HTMLFilter do filter");
        request.setRequestStr(request.getRequestStr().replace("*", "=") + "---HTMLFilter()");
        filterChain.doFilter(request, response, filterChain);
        response.setResponseStr(response.getResponseStr() + "---HTMLFilter()");
    }
}
