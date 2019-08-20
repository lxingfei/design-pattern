package com.leh.proxy.jdk;

/**
 * @Auther: leh
 * @Date: 2019/8/20 09:54
 * @Description: 刚毕业学生，要租房
 * //回顾一下，满足代理模式应用场景的三个必要条件，穷取法
        1、两个角色：执行者、被代理对象
        2、注重过程，必须要做，被代理对象没时间做或者不想做，不专业
        3、执行者必须拿到被代理对象的个人资料（执行者持有被代理对象的引用）
 */
public class StudentRenter implements Renter{

    private String gender;

    private String age;

    @Override
    public void rentHouse() {
        System.out.println("租一个带阳台");
        System.out.println("独立厨卫的80平米的");
        System.out.println("租金5000左右的");
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
