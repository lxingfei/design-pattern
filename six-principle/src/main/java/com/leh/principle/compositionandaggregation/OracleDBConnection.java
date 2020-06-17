package com.leh.principle.compositionandaggregation;

/**
 * @ClassName OracleDBConnection
 * @Description TODO
 * @Author lveh
 * @Date 2020/6/17 15:36
 * @Version 1.0
 **/
public class OracleDBConnection extends DBConnection{

    @Override
    public String getConnection() {
        return "ORACLE 数据库连接";
    }
}
