package com.leh.singleton.multiway;

/**
 * @Auther: leh
 * @Date: 2019/8/27 15:39
 * @Description: 单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。
 * 这种类型的设计模式属于创建型模式。
 * 在 GOF 书中给出的定义为：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * https://mp.weixin.qq.com/s?__biz=MzI3NzE0NjcwMg==&mid=402577543&idx=1&sn=41c4bf5f46d13806668edacce130468b&scene=21#wechat_redirect
 *
 *
 * https://blog.csdn.net/moakun/article/details/80688851
 * 为什么我强烈建议大家使用枚举来实现单例
 * 单元素的枚举类型已经成为实现Singleton的最佳方法
 *
 *
 * 枚举单例写法简单:
 * 相比双重锁校验的代码之所以很臃肿， com.leh.singleton.multiway.SingletonLazy3Dcl_Volatile
 * 是因为大部分代码都是在保证线程安全。
 * 为了在保证线程安全和锁粒度之间做权衡，代码难免会写的复杂些。
 * 而且还是有问题的，因为他无法解决反序列化会破坏单例的问题。

  使用非枚举的方式实现单例，都要自己来保证线程安全，所以，这就导致其他方法必然是比较臃肿的

    枚举可解决线程安全问题

    为什么使用枚举就不需要解决线程安全问题呢？

    其实，并不是使用枚举就不需要保证线程安全，只不过线程安全的保证不需要我们关心而已。
    也就是说，其实在“底层”还是做了线程安全方面的保证的。

    static类型的属性会在类被加载之后被初始化, 当一个Java类第一次被真正使用到的时候静态资源被初始化, Java类的加载和初始化过程都是线程安全的
    （因为虚拟机在加载枚举的类的时候，会使用ClassLoader的loadClass方法，而这个方法使用同步代码块保证了线程安全）
     所以，观察枚举反编译后的代码得知 创建一个enum类型是线程安全的。


    我们定义的一个枚举，在第一次被真正用到的时候，会被虚拟机加载并初始化，而这个初始化过程是线程安全的。
    而我们知道，解决单例的并发问题，主要解决的就是初始化过程中的线程安全问题。

    所以，由于枚举的以上特性，枚举实现的单例是天生线程安全的。



 */
public enum SingletonEnum {

    INSTANCE;

    public void whateverMethod() {

    }

}
