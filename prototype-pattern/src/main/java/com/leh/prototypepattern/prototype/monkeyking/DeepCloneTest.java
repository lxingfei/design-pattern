package com.leh.prototypepattern.prototype.monkeyking;

/**
 * @Auther: leh
 * @Date: 2019/8/29 16:22
 * @Description:
 */
public class DeepCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        MonkeyKing king = new MonkeyKing();

        king.changeShallow();

        System.out.println("-------------------------------------------");

        king.changeDeep();

        /**
         *
         猴王诞生了
         shllow 大圣本尊生日是：1567067465860
         shllow 克隆大圣生日是：1567067465860
         shllow 大圣本尊和克隆大圣是否为同一个对象:false
         shllow 大圣本尊持有的金箍棒跟克隆大圣持有金箍棒是否为同一个对象:true
         -------------------------------------------
         deepClone 大圣本尊生日是：1567067465860
         deepClone 克隆大圣生日是：1567067465928
         deepClone 大圣本尊和克隆大圣是否为同一个对象:false
         deepClone 大圣本尊持有的金箍棒跟克隆大圣持有金箍棒是否为同一个对象:false
         *
         */

    }
}
