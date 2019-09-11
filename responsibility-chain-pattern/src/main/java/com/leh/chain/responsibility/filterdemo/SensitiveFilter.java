package com.leh.chain.responsibility.filterdemo;

import com.leh.chain.responsibility.model.Request;
import com.leh.chain.responsibility.model.Response;

/**
 * @Auther: leh
 * @Date: 2019/9/10 18:24
 * @Description:敏感字符过滤
 */
public class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        System.out.println("SensitiveFilter do filter");
        request.setRequestStr(request.getRequestStr().replace("FUCK", "") + "---SensitiveFilter()");
        filterChain.doFilter(request, response, filterChain);
        response.setResponseStr(response.getResponseStr() + "---SensitiveFilter()");
    }
}
