package com.leh.prototypepattern.prototype.monkeyking;

import java.io.*;
import java.util.Date;

/**
 * @Auther: leh
 * @Date: 2019/8/29 16:00
 * @Description:
 */
public class MonkeyKing extends Monkey implements Cloneable, Serializable {

    private GoldRingStaff goldRingStaff;

    public MonkeyKing() {
        this.weight = 30;
        this.height = 150;
        this.birthday = new Date();
        this.goldRingStaff = new GoldRingStaff();
        System.out.println("猴王诞生了");
    }

    public GoldRingStaff getGoldRingStaff() {
        return goldRingStaff;
    }

    public void setGoldRingStaff(GoldRingStaff goldRingStaff) {
        this.goldRingStaff = goldRingStaff;
    }

    /**
     * 默认浅克隆，只克隆八大基本数据类型和String
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 分身技能
     * 深克隆
     */
    public Object deepClone() {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);

            //序列化
            oos.writeObject(this);

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);

            MonkeyKing copy = (MonkeyKing) ois.readObject();
            copy.birthday = new Date();
            return copy;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                oos.close();
                bos.close();
                ois.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void changeDeep() throws CloneNotSupportedException {
        MonkeyKing copy = (MonkeyKing) deepClone();
        System.out.println("deepClone 大圣本尊生日是：" + this.getBirthday().getTime());
        System.out.println("deepClone 克隆大圣生日是：" + copy.getBirthday().getTime());
        System.out.println("deepClone 大圣本尊和克隆大圣是否为同一个对象:" + (this == copy));
        System.out.println("deepClone 大圣本尊持有的金箍棒跟克隆大圣持有金箍棒是否为同一个对象:"
                + (this.getGoldRingStaff() == copy.getGoldRingStaff()));
    }

    public void changeShallow() throws CloneNotSupportedException {

        MonkeyKing shllow = (MonkeyKing) clone();

        System.out.println("shllow 大圣本尊生日是：" + this.getBirthday().getTime());
        System.out.println("shllow 克隆大圣生日是：" + shllow.getBirthday().getTime());
        System.out.println("shllow 大圣本尊和克隆大圣是否为同一个对象:" + (this == shllow));
        System.out.println("shllow 大圣本尊持有的金箍棒跟克隆大圣持有金箍棒是否为同一个对象:"
                + (this.getGoldRingStaff() == shllow.getGoldRingStaff()));
    }

}
