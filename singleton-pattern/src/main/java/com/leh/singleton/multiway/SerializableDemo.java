package com.leh.singleton.multiway;

import java.io.*;

/**
 * 深度解析单例与序列化之间的爱恨情仇
 * https://mp.weixin.qq.com/s?__biz=MzI3NzE0NjcwMg==&mid=2650120643&idx=1&sn=72ffc1018f5fe4451f885be56e972b30&chksm=f36bbce2c41c35f4d18a841b6fcc5688e7ab3d520be46bc72825b16c0d507a31e48f77dcf0fa&scene=21#wechat_redirect
 * @Auther: leh Double-Checked Lock
 * @Date: 2019/8/27 11:18
 * @Description: 1、	懒汉式单例.双重锁检查 + volatile
 * <p>
 * 优点：解决JMM相关的缓存一致性问题（在线程A完成初始化之前共享变量对线程B可见）
 * 缺点： 即使是这种看上去完美无缺的方式也可能存在问题，那就是遇到序列化的时候
 * <p>
 *     单例模式真的能够实现实例的唯一性吗？
 *     1 反射可以破坏单例模式
 *     2 序列化与反序列化也同样会破坏单例
 */
public class SerializableDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "D:/tsfa-leh";
        String fileName = "singleton.txt";
        //write obj to file
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "/" + fileName));

        oos.writeObject(SingletonLazy3Dcl_Volatile.getInstance());

        //read obj from file
        File file = new File(path + "/" + fileName);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        SingletonLazy3Dcl_Volatile deserializeSingleton = (SingletonLazy3Dcl_Volatile) ois.readObject();


        //判断是否为同一个对象  false
        System.out.println(deserializeSingleton == SingletonLazy3Dcl_Volatile.getInstance());

        oos.close();
        ois.close();

        boolean r = delFile(file);

        if (r) {
            System.out.println("delete success");
        }else {
            System.out.println("delete fail");
        }


    }

    public static boolean delFile(File file) {

        if (file.exists() && file.isFile()){
            return file.delete();
        }
        return false;
    }
    /**
     * 输出结果为false，说明：
     * 通过对Singleton的序列化与反序列化得到的对象是一个新的对象，这就破坏了Singleton的单例性。
     */

}
