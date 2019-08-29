package com.leh.factorypattern.factory.simple;

import com.leh.factorypattern.factory.model.AudiCar;
import com.leh.factorypattern.factory.model.BenzCar;
import com.leh.factorypattern.factory.model.BmwCar;
import com.leh.factorypattern.factory.model.Car;

/** 简单工厂模式
 * @Auther: leh
 * @Date: 2019/8/28 17:50
 * @Description:
 * 编码也是一种艺术(融汇贯通),艺术来源于生活，回归到生活的
 *  实现统一管理、专业化管理
    如果没有工厂模式，小作坊，没有执行标准的

    中国制造(按人家的标准执行)
    中国制造向中国创造改变(技术不是问题了，问题是什么？思维能力)
    码农就是执行标准的人
    系统架构师，就是制定标准的人

    不只做一个技术者，更要做一个思考者

 */
public class SimpleFactory {

    public static Car getInstance(String name) {

        /**
         Spring中的工厂模式
         BeanFactory（生成Bean）
         单例的Bean
         被代理过的Bean
         最原始的Bean（原型）
         List类型的Bean
         作用域不同的Bean

         相当于getBean
         非常的紊乱，维护困难 （再添加需要改代码）
         解耦（松耦合开发）
         */

        switch (name) {
            case "AUDI":
                return new AudiCar();
            case "BMW":
                return new BmwCar();
            case "BENZ":
                return new BenzCar();
            default:
                System.out.println("这个产品产不出来");
                return null;
        }
    }

}
