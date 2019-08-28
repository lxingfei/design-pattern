package com.leh.singleton.multiway;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: leh
 * @Date: 2019/8/28 14:17
 * @Description: 登记式单例
 */
public class SingletonRegister {
    //类似Spring里面的方法，将类名注册，下次从里面直接获取。
    private static Map<String, SingletonRegister> map = new HashMap<>();

    static {
        SingletonRegister instance = new SingletonRegister();
        map.put(instance.getClass().getName(), instance);
    }

    //保护的默认构造
    protected SingletonRegister() {

    }

    //静态工厂方法,返还此类惟一的实例
    public static SingletonRegister getInstance(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (name == null) {
            return map.get(SingletonRegister.class.getName());
        }
        if (map.get(name) == null) {
            map.put(name, (SingletonRegister) Class.forName(name).newInstance());
        }

        return map.get(name);

    }


}
