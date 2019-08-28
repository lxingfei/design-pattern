package com.leh.singleton.multiway;

import java.io.Serializable;

/**
 * @Auther: leh Double-Checked Lock
 * @Date: 2019/8/27 11:18
 * @Description: 1、	懒汉式单例.双重锁检查 + volatile
 *
 *                  优点：解决JMM相关的缓存一致性问题（在线程A完成初始化之前共享变量对线程B可见）
 *                  缺点： 即使是这种看上去完美无缺的方式也可能存在问题，那就是遇到序列化的时候

 *
 */

public class SingletonLazy3Dcl_Volatile implements Serializable{

    private SingletonLazy3Dcl_Volatile(){}

    private static volatile SingletonLazy3Dcl_Volatile instance = null;


    public static SingletonLazy3Dcl_Volatile getInstance(){
        if(instance == null){
          synchronized (SingletonLazy3Dcl_Volatile.class){
              if(instance == null){
                  instance = new SingletonLazy3Dcl_Volatile();
              }
          }
        }
        return instance;
    }

    public Object readResolve(){
        return instance;
    }

}
