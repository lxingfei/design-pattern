package com.leh.prototypepattern.prototype.monkeyking;

import java.io.Serializable;

/**
 * @Auther: leh
 * @Date: 2019/8/29 15:57
 * @Description: 金箍棒
 */
public class GoldRingStaff implements Serializable{
    //长度
    private float height = 100;

    //直径
    private float diameter = 10;


    /**
     * 金箍棒长大
     */
    public void grow(){
        this.diameter *= 2;
        this.height *= 2;
    }

    /**
     * 金箍棒缩小
     */
    public void shrink(){
        this.diameter /= 2;
        this.height /= 2;
    }
}
