package com.leh.singleton.multiway;

/**
 * @Auther: leh
 * @Date: 2019/8/27 11:18
 * @Description: 1、	在getInstance方法上加同步  保证线程安全
 *                  缺点：
 *                  性能问题：多个线程同时访问这个方法时，会因为同步而导致每次只有一个线程运行，影响程序性能。
 *                  而事实上初始化完毕后只需要简单的返回instance的引用就行了。
 */
public class SingletonLazySync {
    //1、第一步先将构造方法私有化
    private SingletonLazySync(){}

    //2、然后声明一个静态变量保存单例的引用
    private static SingletonLazySync instance = null;

    //3、通过提供一个静态方法来获得单例的引用

    //为了保证多线程环境下正确访问，给实例化方法加上同步锁synchronized
    //慎用  synchronized 关键字，阻塞，性能非常低下的
    //加上synchronized关键字以后，对于getInstance()方法来说，它始终单线程来访问
    //没有充分利用上我们的计算机资源，造成资源的浪费
    public synchronized static SingletonLazySync getInstance(){
        if(instance == null){
            //获得锁的线程1此刻即使发生时间片切换（同步方法未执行完仍旧持有锁），
            //线程2在调用实例化方法时无法获取锁而不能创建实例 实现线程安全
            instance = new SingletonLazySync();
        }
        return instance;
    }


    /**
     * 当我们使用锁 synchronized 同步代码的时候，会在什么时候释放锁呢？？？？？？
     *
        1.当前线程的同步方法、代码块执行结束的时候释放。
        2.当前线程在同步方法、同步代码块中遇到break 、 return 终于该代码块或者方法的时候释放。
        3.出现未处理的error或者exception导致异常结束的时候释放。
        4.程序执行了 同步对象 wait 方法 ，当前线程暂停，释放锁

        在以下两种情况不会释放锁
        1. 代码块中使用了 Thread.sleep()  Thread.yield() 这些方法暂停线程的执行，不会释放。
        2. 线程执行同步代码块时，其他线程调用 suspend 方法将该线程挂起，该线程不会释放锁 ，所以我们应该避免使用 suspend 和 resume 来控制线程 。


        1. 对于一个已经竞争到同步锁的线程，在还没有走出同步块的时候，即使时间片结束也不会释放锁。
        2.  对象锁和类锁是两个不同的锁。在同一个类的静态方法和实例方法上都加synchronized关键字，
            这时静态方法的synchronized对应的是 **类锁**，实例方法的synchronized是**对象锁**。
            这是两个不同的锁。
     */


}
