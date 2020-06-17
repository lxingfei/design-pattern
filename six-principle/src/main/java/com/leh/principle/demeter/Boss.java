package com.leh.principle.demeter;

/**
 * @ClassName 迪米特原则：最少知识原则
 * @Description 一个类对于其他类知道的越少越好，就是说一个对象应当对其他对象有尽可能少的了解,
 * 只和朋友通信，不和陌生人说话
 * @Author lveh
 * @Date 2020/6/17 15:25
 * @Version 1.0
 **/
public class Boss {
    public void commandCheckNumber(TeamLeader teamLeader){
        teamLeader.checkNumberOfCourses();
    }

}
