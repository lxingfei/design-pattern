package com.leh.command.demo;

/**
 * @ClassName Manager
 * @Description TODO
 * @Author lveh
 * @Date 2020/6/17 16:29
 * @Version 1.0
 **/
public class Manager implements Employee{
    private String title = "部门经理";
    private String department;
    private String reportContent;

    public Manager(String department) {
        this.department = department;
    }

    public void setReportContent(String reportContent){
        this.reportContent = reportContent;
    }

    @Override
    public void report() {
        System.out.println(reportContent);
    }
}
