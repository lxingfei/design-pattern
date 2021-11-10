package com.leh.observer.event;

import org.apache.catalina.User;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @PackageName:com.leh.observer.event
 * @ClassName:UserRegisterEventPublisher
 * @Description 用户注册事件发布
 * @Author lveh
 * @create: 2021-11-11 01:55
 * @Version 1.0
 **/
@Component
public class UserRegisterEventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(User user){
        this.applicationEventPublisher.publishEvent(new UserRegisterEvent(this, user));
    }
}
