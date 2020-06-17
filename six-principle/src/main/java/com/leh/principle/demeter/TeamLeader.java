package com.leh.principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TeamLeader
 * @Description TODO
 * @Author lveh
 * @Date 2020/6/17 15:26
 * @Version 1.0
 **/
public class TeamLeader {

    public void checkNumberOfCourses(){
        List<Course> courseList = new ArrayList<Course>();
        for(int i = 0 ;i < 20;i++){
            courseList.add(new Course());
        }
        System.out.println("在线课程的数量是："+courseList.size());
    }
}
