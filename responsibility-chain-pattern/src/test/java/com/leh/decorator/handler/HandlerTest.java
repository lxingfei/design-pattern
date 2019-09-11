package com.leh.decorator.handler;

import com.leh.decorator.responsibility.handlerdemo.GMHandler;
import com.leh.decorator.responsibility.handlerdemo.PMHandler;
import com.leh.decorator.responsibility.model.LeaveRequest;

/**
 * @Auther: leh
 * @Date: 2019/9/11 09:57
 * @Description:
 */
public class HandlerTest {

    public static void main(String[] args) {

        PMHandler pmHandler = new PMHandler();
        GMHandler gmHandler = new GMHandler();

        LeaveRequest req = new LeaveRequest("张三", 5, 5);

        //设置传递顺序
        pmHandler.setNextHandler(gmHandler);

        pmHandler.process(req);

        /*
            output:
            项目经理转交总经理
            张三,你通过总经理审批!
         */
    }
}
