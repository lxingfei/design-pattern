package com.leh.principle.openclose;

/**
 * @ClassName JavaCourse
 * @Description 开放封闭原则
 *  原则思想：对扩展开放，对修改关闭
    优点：单一原则告诉我们，每个类都有自己负责的职责，
          里氏替换原则不能破坏继承关系的体系
 * @Author lveh
 * @Date 2020/5/30 16:40
 * @Version 1.0
 **/
public class JavaCourse implements ICourse {

    private Integer id;

    private String name;

    private Double price;

    public JavaCourse(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Double getPrice() {
        return null;
    }
}
