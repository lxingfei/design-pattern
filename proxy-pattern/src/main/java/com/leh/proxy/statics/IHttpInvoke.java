package com.leh.proxy.statics;

/**
 * @Description IHttpInvoke(抽象角色)
 * @Param 以浏览器访问服务器的简单举例：
 * 模拟浏览器向服务器发生消息，经过代理转码后服务器收到请求消息并响应信息，
 * 经过代理记录日志，最后浏览器才接收到响应信息。
 * @return
 **/
public interface IHttpInvoke {
    String invoke(String request);
}
