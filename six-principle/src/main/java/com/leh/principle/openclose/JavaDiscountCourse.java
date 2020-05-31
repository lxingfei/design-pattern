package com.leh.principle.openclose;

/**
 * @ClassName JavaDiscountCourse
 * @Description TODO
 * @Author lveh
 * @Date 2020/5/30 16:42
 * @Version 1.0
 **/
public class JavaDiscountCourse extends JavaCourse{

    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }


    public Double getDiscountPrice() {
        return super.getPrice() * 0.8;
    }
}
