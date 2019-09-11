package com.leh.chain.responsibility.model;

/**
 * @Auther: leh
 * @Date: 2019/9/11 09:47
 * @Description: 请假请求
 */
public class LeaveRequest {

    // 请假人姓名
    private String name;

    // 请假天数
    private int numOfDays;

    //员工工龄(在公司大于2年则总经理会审批)
    private int workingAge;

    public LeaveRequest() {
    }

    public LeaveRequest(String name, int numOfDays, int workingAge) {
        this.name = name;
        this.numOfDays = numOfDays;
        this.workingAge = workingAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    public int getWorkingAge() {
        return workingAge;
    }

    public void setWorkingAge(int workingAge) {
        this.workingAge = workingAge;
    }
}
