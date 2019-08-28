package com.leh.singleton.multiway;

/**
 * @Auther: leh
 * @Date: 2019/8/27 11:01
 * @Description: 懒汉式单例类.在第一次调用的时候实例化自己
 * 好处：实现延迟初始化(Lazy initialization)，比如这个实例初始化时的参数要在运行期才能确定
 * 缺点：
 * 假设这样一个场景，有两个线程调用Singleton.getInstance()，首先线程一判断instance是否等于null，
 * 判断完后一瞬间虚拟机把线程二调度为运行线程，线程二再次判断instance是否为null，然后创建一个Singleton实例，
 * 线程二的时间片用完后，线程一被唤醒，接下来它执行的代码依然是instance = new Singleton();
   两次调用返回了不同的对象，出现问题了
 */
public class SingletonLazy1 {

    //1、第一步先将构造方法私有化
    private SingletonLazy1(){}

    //2、然后声明一个静态变量保存单例的引用
    private static SingletonLazy1 instance = null;

    //3、通过提供一个静态方法来获得单例的引用
    //线程不安全的 并发环境下很可能出现多个 SingletonLazy 实例
    public static SingletonLazy1 getInstance(){
        if(instance == null){
            instance = new SingletonLazy1();
        }
        return instance;
    }

   /* public static void main(String[] args) {

        new Thread(() -> {
            SingletonLazy1 s1 = SingletonLazy1.getInstance();
            System.out.println(s1);
        }).start();


        new Thread(() -> {
            SingletonLazy1 s2 = SingletonLazy1.getInstance();
            System.out.println(s2);
        }).start();

        new Thread(() -> {
            SingletonLazy1 s3 = SingletonLazy1.getInstance();
            System.out.println(s3);
        }).start();

    }*/

    /**
     * com.leh.singleton.multiway.SingletonLazy1@14550b42
     com.leh.singleton.multiway.SingletonLazy1@79a19a06
     com.leh.singleton.multiway.SingletonLazy1@14550b42

     com.leh.singleton.multiway.SingletonLazy1@ae526cf
     com.leh.singleton.multiway.SingletonLazy1@2ceb2de
     com.leh.singleton.multiway.SingletonLazy1@2ceb2de
     */

}
