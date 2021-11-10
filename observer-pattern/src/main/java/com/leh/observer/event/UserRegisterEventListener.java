package com.leh.observer.event;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @PackageName:com.leh.observer.event
 * @ClassName:UserRegisterEventListener
 * @Description 用户注册事件监听
 * @Author lveh
 * @create: 2021-11-11 02:00
 * @Version 1.0
 **/
@Component
@Slf4j
public class UserRegisterEventListener implements ApplicationListener<UserRegisterEvent> {
    @SneakyThrows
    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        User user = userRegisterEvent.getUser();
        log.info("用户:{},进行了注册，开始发放奖励", user.getUsername());
        Thread.sleep(1000);
        log.info("执行发放奖品");
        Thread.sleep(1000);
        log.info("执行发放积分");
        Thread.sleep(1000);
        log.info("执行发送短信");
        Thread.sleep(1000);
        log.info("新用户奖励发放完成");

    }
}
