package com.leh.prototypepattern.prototype.simple;

import java.util.ArrayList;

/**
 * @Auther: leh
 * @Date: 2019/8/29 15:34
 * @Description:
 */
public class ConcretePrototype implements Cloneable {

    public ArrayList<String> list = new ArrayList<>();
    private String name;
    private int age;

    /**
     * 克隆基于字节码的
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        ConcretePrototype prototype = (ConcretePrototype) super.clone();
        prototype.list = (ArrayList<String>) list.clone();

        return prototype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
