package com.leh.principle.compositionandaggregation;

/**
 * @ClassName 组合聚合原则
 * @Description TODO
 * @Author lveh
 * @Date 2020/6/17 15:39
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        dao.setDbConnection(new MysqlDBConnection());
        dao.addProduct();
    }

}
