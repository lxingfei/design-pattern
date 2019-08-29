package com.leh.prototypepattern.prototype.simple;

/**
 * @Auther: leh
 * @Date: 2019/8/29 15:40
 * @Description: 原型模式
 *
 *
 */
public class CloneTest {
    public static void main(String[] args) {
        ConcretePrototype source = new ConcretePrototype();

        source.setAge(16);

        source.setName("leh");

        //source.list.add("test");

        try {
            ConcretePrototype copy = (ConcretePrototype) source.clone();

            System.out.println(copy == source); //false

            System.out.println(copy.list == source.list);//false


            System.out.println(copy.getAge() + "," + copy.getName() + "," + copy.list.size());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }

    /**
     * 一个现成的对象，这个对象里面有已经设置好的值
       当我要新建一个对象，并且要给新建的对象赋值，
       而且赋值内容要跟之前的一模一样

      用循环，用反射，也确实可以的（反射性能并不高）
      字节码复制 newInstance()
     * @return
     */
    public ConcretePrototype anotherMethod(){
        ConcretePrototype cp = new ConcretePrototype();
        cp.setAge(18);
        cp.setName("leh");

        ConcretePrototype copy = new ConcretePrototype();
        copy.setAge(cp.getAge());
        copy.setName(cp.getName());

        return copy;
    }

    /**
     * 浅拷贝与深拷贝
     *
     * 浅拷贝 能够直接拷贝其实际内容的数据类型/只支持9种,八大基本数据类型+String
     * 深拷贝
     */
}
