package com.leh.command.demo;

/**
 * @ClassName Test
 * @Description TODO
 * @Author lveh
 * @Date 2020/6/17 16:36
 * @Version 1.0
 **/
public class Test {
    private static final String departments[] = {"RD","QA","PM","BD"};

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String department = departments[(int) (Math.random() * departments.length)];
            Manager manager = (Manager) EmployeeFactory.getManager(department);
            manager.report();
        }
    }
}
