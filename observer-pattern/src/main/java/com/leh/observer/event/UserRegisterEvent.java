package com.leh.observer.event;

import org.apache.catalina.User;
import org.springframework.context.ApplicationEvent;

/**
 * @PackageName:com.leh.observer
 * @ClassName:UserRegisterEvent
 * @Description 用户注册事件
 * @Author lveh
 * @create: 2021-11-11 01:51
 * @Version 1.0
 **/
public class UserRegisterEvent extends ApplicationEvent {
    private User user;
    public UserRegisterEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
