package com.leh.singleton.multiway;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Auther: leh
 * @Date: 2019/8/27 11:18
 * @Description: 不使用synchronized和lock，实现一个线程安全的单例
 * 使用枚举、静态内部类以及饿汉模式来实现单例模式 都间接使用了同步锁机制保证线程安全
 * <p>
 * 可借助 CAS无锁算法（AtomicReference）实现单例模式：
 * <p>
 * CAS是项乐观锁技术，当多个线程尝试使用CAS同时更新同一个变量时，只有其中一个线程能更新变量的值，
 * 而其它线程都失败，失败的线程并不会被挂起，而是被告知这次竞争中失败，并可以再次尝试。
 * <p>
 * 优点：
 * 在JDK1.5 中新增java.util.concurrent(J.U.C)就是建立在CAS之上的。
 * 相对于对于synchronized这种阻塞算法，CAS是非阻塞算法的一种常见实现。
 * 所以J.U.C在性能上有了很大的提升。
 */
public class SingletonLazyCAS {

    private static final AtomicReference<SingletonLazyCAS> INSTANCE = new AtomicReference<>();

    private SingletonLazyCAS() {

    }

    public static SingletonLazyCAS getInstance() {
        for (; ; ) {
            SingletonLazyCAS singleton = INSTANCE.get();

            if(singleton != null){
                return singleton;
            }
            singleton = new SingletonLazyCAS();
            if(INSTANCE.compareAndSet(null, singleton)){
                return singleton;
            }
        }
    }

    /**
     *  优劣势：
     *
     * 用CAS的好处在于
     * 不需要使用传统的锁机制来保证线程安全,CAS是一种基于忙等待的算法（无锁算法）,
     * 依赖底层硬件的实现,相对于锁它没有线程切换和阻塞的额外消耗,可以支持较大的并行度。

       CAS的一个重要缺点在于
       如果忙等待一直执行不成功(一直在死循环中),会对CPU造成较大的执行开销。
     */

}
