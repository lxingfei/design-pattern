package com.leh.singleton.multiway;

/**
 * @Auther: leh Double-Checked Lock
 * @Date: 2019/8/27 11:18
 * @Description: 1、	懒汉式单例.双重锁检查
 *
 *                  优点：双检锁机制的出现确实是解决了多线程并行中不会出现重复new对象，而且也实现了懒加载，与同步方法相比性能提升
 *                  缺点： instance = new DoubleCheckedLock()在编译器下实现是有过程的：
 *                      1) 分配新的Singleton对象的内存
                        2) 调用Singleton的构造器，初始化成员字段
                        3) instance被赋为指向新的对象的引用。
                    而编译器或处理器都为了提高性能都有可能进行指令的乱序执行，线程一的真正执行步骤可能是:
                        1) 分配内存
                        2) instance指向新对象
                        3) 初始化新实例
                    假设一个场景：
                    线程一进入同步块，执行instance = new Singleton(); 线程二刚开始执行getInstance();
                    如果线程二在2完成后3执行前被唤醒，它看到了一个不为null的instance，跳出方法体走了，带着一个还没初始化的Singleton对象。

 *
 */
public class SingletonLazy3Dcl {
    //1、第一步先将构造方法私有化
    private SingletonLazy3Dcl(){}

    //2、然后声明一个静态变量保存单例的引用
    private static SingletonLazy3Dcl instance = null;

    //3、通过提供一个静态方法来获得单例的引用
    //为了保证多线程环境下的另一种实现方式，双重锁检查
    //性能：第一次创建的时候
    public static SingletonLazy3Dcl getInstance(){
        if(instance == null){
          synchronized (SingletonLazy3Dcl.class){
              if(instance == null){
                  instance = new SingletonLazy3Dcl();
              }
          }
        }
        return instance;
    }

}
