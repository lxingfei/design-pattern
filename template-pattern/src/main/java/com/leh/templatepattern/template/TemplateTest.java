package com.leh.templatepattern.template;

/**
 * @Auther: leh
 * @Date: 2019/8/29 16:49
 * @Description:
 */
public class TemplateTest {
    public static void main(String[] args) {

        Coffee coffee = new Coffee();
        coffee.create();

        Tea tea = new Tea();
        tea.create();

        /**
         烧开水，烧到100度可以起锅了
         准备杯子,并放入咖啡
         将开水放入杯中进行冲泡
         添加辅料：牛奶和糖


         烧开水，烧到100度可以起锅了
         准备杯子，并放入茶叶
         将开水放入杯中进行冲泡
         添加辅料：蜂蜜
         */

        /**
         *
         SpringJDBC
         是java规范，各个数据库厂商自己去实现
         1、加载驱动类DriverManager
         2、建立连接
         3、创建语句集(标准语句集、预处理语句集)(语句集？  MySQL、Oracle、SQLServer、Access)
         4、执行语句集
         5、结果集ResultSet 游标
         ORM(?)
         *
         */


    }
}
