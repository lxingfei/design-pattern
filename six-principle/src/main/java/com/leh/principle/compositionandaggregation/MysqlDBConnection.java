package com.leh.principle.compositionandaggregation;

/**
 * @ClassName MysqlDBConnection
 * @Description TODO
 * @Author lveh
 * @Date 2020/6/17 15:35
 * @Version 1.0
 **/
public class MysqlDBConnection extends DBConnection{

    @Override
    public String getConnection() {
        return "MySQL数据库连接";
    }
}
