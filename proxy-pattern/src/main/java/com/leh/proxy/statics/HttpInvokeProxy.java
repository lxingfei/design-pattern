package com.leh.proxy.statics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * @Description HttpInvokeProxy(代理对象)
 * @Author lveh
 * @Date 2021/3/10 10:39
 * @Version 1.0
 **/
public class HttpInvokeProxy implements IHttpInvoke {
    private Logger logger = LoggerFactory.getLogger(String.valueOf(getClass()));

    private IHttpInvoke iHttpInvoke;

    public HttpInvokeProxy(IHttpInvoke iHttpInvoke) {
        this.iHttpInvoke = iHttpInvoke;
    }

    @Override
    public String invoke(String request) {
        String req = before(request);
        String response = iHttpInvoke.invoke(req);
        after(response);
        return response;
    }

    public String before(String request){
        logger.info("请求数据：" + request);
        byte[] req = request.getBytes();
        String requestData = null;
        try {
            requestData = new String(req,"GBK");
            logger.info("转码成功，返回请求数据");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return requestData;
    }

    public void after(String response){
        logger.info("响应数据: " + response);
    }
}
