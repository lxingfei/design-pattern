package com.leh.proxy.statics;

/**
 * @Description Browser(浏览器客户端)：
 * @Author lveh
 * @Date 2021/3/10 10:40
 * @Version 1.0
 **/
public class Browser {
    public static void main(String[] args) {
        String request = "给我一个亿！";
        IHttpInvoke httpInvokeProxy = new HttpInvokeProxy(new Server());
        httpInvokeProxy.invoke(request);
    }
}
