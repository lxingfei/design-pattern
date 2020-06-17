package com.leh.principle.demeter;

/**
 * @ClassName DemeterTest
 * @Description
 * @Author lveh
 * @Date 2020/6/17 15:28
 * @Version 1.0
 **/
public class DemeterTest {
    public static void main(String[] args) {
        Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();
        boss.commandCheckNumber(teamLeader);
    }
}
