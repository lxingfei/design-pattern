package com.leh.prototypepattern.prototype.monkeyking;

import java.util.Date;

/**
 * @Auther: leh
 * @Date: 2019/8/29 15:55
 * @Description:
 */
public class Monkey {
    //身高 基本类型
    protected int height;

    //体重 基本类型
    protected int weight;

    //生日 不是基本类型
    protected Date birthday;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
