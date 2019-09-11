package com.leh.chain.responsibility.filterdemo;

import com.leh.chain.responsibility.model.Request;
import com.leh.chain.responsibility.model.Response;

/**
 * @Auther: leh
 * @Date: 2019/9/10 18:19
 * @Description:
 */
public interface Filter {

    void doFilter(Request request, Response response, FilterChain filterChain);

}
