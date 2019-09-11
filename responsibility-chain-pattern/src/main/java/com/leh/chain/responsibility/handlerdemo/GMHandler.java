package com.leh.chain.responsibility.handlerdemo;

import com.leh.chain.responsibility.model.LeaveRequest;

/**
 * @Auther: leh
 * @Date: 2019/9/11 09:56
 * @Description:
 * 总经理处理者，能处理大于3天的假期，且工龄超过2年才会审批通过：
 */
public class GMHandler extends AbstractApproveHandler {

    @Override
    public void process (LeaveRequest leaveRequest){
        //员工在公司工龄超过2年,则审批通过
        if (leaveRequest.getWorkingAge() >= 2 && leaveRequest.getNumOfDays() > 3) {
            System.out.println(leaveRequest.getName() + ",你通过总经理审批!");
            if (null != nextHandler) {
                nextHandler.process(leaveRequest);
            }
        } else {
            System.out.println("在公司年限不够,长假未通过总经理审批!");
            return;
        }
    }
}
