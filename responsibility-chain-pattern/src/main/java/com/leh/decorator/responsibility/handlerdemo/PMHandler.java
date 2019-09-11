package com.leh.decorator.responsibility.handlerdemo;

import com.leh.decorator.responsibility.model.LeaveRequest;

/**
 * @Auther: leh
 * @Date: 2019/9/11 09:54
 * @Description:
 * 项目经理处理者，能处理小于3天的假期，而请假信息里没有名字时，审批不通过：
 */
public class PMHandler extends AbstractApproveHandler {

    @Override
    public void process(LeaveRequest leaveRequest) {

        //未填写姓名的请假单不通过
        if (null != leaveRequest.getName()) {
            if (leaveRequest.getNumOfDays() <= 3) {
                System.out.println(leaveRequest.getName() + ",你通过项目经理审批!");
            } else {
                System.out.println("项目经理转交总经理");
                if (null != nextHandler) {
                    nextHandler.process(leaveRequest);
                }
            }
        } else {
            System.out.println("请假单未填写完整,未通过项目经理审批!");
            return;
        }
    }
}
