package com.leh.principle.openclose;

/**
 * @ClassName OpenCloseTest
 * @Description TODO
 * @Author lveh
 * @Date 2020/5/30 16:44
 * @Version 1.0
 **/
public class OpenCloseTest {
    public static void main(String[] args) {
        ICourse iCourse = new JavaDiscountCourse(96, "Java从零到企业级电商开发", 348d);
        // 将抽象类型强转为具体类型
        JavaDiscountCourse discountCourse = (JavaDiscountCourse) iCourse;
        System.out.println("课程ID:" + discountCourse.getId() + " 课程名称:" + discountCourse.getName() + " 课程原价:" + discountCourse.getPrice() + " 课程折后价格:" + discountCourse.getDiscountPrice() + "元");

    }
}
