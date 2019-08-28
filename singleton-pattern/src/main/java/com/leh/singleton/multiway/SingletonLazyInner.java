package com.leh.singleton.multiway;

/**
 * @Auther: leh Double-Checked Lock
 * @Date: 2019/8/27 11:18
 * @Description: 4、	懒汉式单例.静态内部类
 *                  优点：既解决安全问题，又解决了性能问题
 *                  LazyHolder 类没有被主动使用，只有第一次显式通过调用getInstance方法时，
 *                  才会显示装载LazyHolder 类，从而实例化instance
 *
 *                  第一次调用getInstance方法会导致虚拟机加载LazyHolder类
 *
 *                  静态内部类与外部类没有什么大的关系，外部类加载的时候，内部类不会被加载，
 *                  静态内部类只是调用的时候用了外部类的名字而已
 *
 *                  利用了classloder的机制来保证初始化instance时只有一个线程
 *                  原因：虚拟机会保证一个类的构造器<clinit>()方法在多线程环境中被正确地加载，
 *                       同步，如果多个线程同时去初始化一个类，那么只有一个线程去执行这个类的
                        构造器<clinit>()方法，其他线程都需要阻塞等待，直到活动线程执行<clinit>（）方法完毕。

                    特别需要注意的是，
                    在这种情形下，其他线程虽然会被阻塞，但如果执行<clinit>()方法的那条线程退出后，
                    其他线程在唤醒之后不会再次进入/执行<clinit>()方法，因为 在同一个类加载器下，一个类型只会被初始化一次。
                    如果在一个类的<clinit>()方法中有耗时很长的操作，就可能造成多个线程阻塞，在实际应用中这种阻塞往往是隐藏的


 *
 */
public class SingletonLazyInner {

    /**
     * 1、先声明一个静态内部类
     *      private 私有的保证别人不能修改
     *      static 保证全局唯一
     */

    private static class LazyHolder{
        static {
            System.out.println("开始加载 LazyHolder的静态代码块。。。。");
        }
        //final 为了防止内部误操作，代理模式，GgLib的代理模式
        //static final类型的，也就表明只能被实例化一次
        private static final SingletonLazyInner INSTANCE = new SingletonLazyInner();
    }

    static {
        //不管该class有没有实例化，static静态块总会在classLoader执行完以后，就加载完毕
        System.out.println("开始装载 SingletonLazyInner的静态代码块。。。。");
    }

    /**
     * 2、将默认构造方法私有化
     */
    private SingletonLazyInner(){
        System.out.println("开始执行构造方法 SingletonLazyInner()。。。。");

    }


    /**
     * 3 同样提供静态方法获取实例
     * final 确保别人不能覆盖
     * 方法中的逻辑，是要在用户调用的时候才开始执行的
       方法中实现逻辑需要分配内存，也是调用时才分配的
     */

    public static final SingletonLazyInner getInstance(){
        System.out.println("开始调用 getInstance()。。。。");
        return LazyHolder.INSTANCE;
    }

    public static void main(String[] args) {
        SingletonLazyInner.getInstance();
        /**
         * 开始装载 SingletonLazyInner的静态代码块。。。。
           开始调用 getInstance()。。。。
           开始加载 LazyHolder的静态代码块。。。。
           开始执行构造方法 SingletonLazyInner()。。。。
         */
    }

    /**
     * 我们所写的所有的代码，在java的反射机制面前，都是裸奔的
        反射机制是可以拿到 private修饰的内容的
        我们可以理解成即使加上 private也不靠谱（按正常套路出牌，貌似可以）
     */

    //类装载到JVM中过程
    //1 从上往下(必须声明在前，使用在后)
    //2 先属性、后方法
    //3 先静态、后动态



}
