package com.leh.proxy.statics;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description Server(目标对象)
 * @Author lveh
 * @Date 2021/3/10 10:31
 * @Version 1.0
 **/
public class Server implements IHttpInvoke{
    Logger logger = LoggerFactory.getLogger(String.valueOf(getClass()));

    @Override
    public String invoke(String request) {
        String response = "好的!";
        return response;
    }
}
