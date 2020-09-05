package com.leh.command.demo;

/**
 * 核心类说明：
 * @description: Receiver：请求接受者，根据请求对象的指挥进行不同的反应。
 * @author: lveh
 * @time: 2020/9/5 20:12
 */
public class Receiver {
    public void query(){
        System.out.println("query...");
    }
    public void update(){
        System.out.println("update...");
    }
    public void del(){
        System.out.println("del...");
    }
    public void insert(){
        System.out.println("insert...");
    }
}
