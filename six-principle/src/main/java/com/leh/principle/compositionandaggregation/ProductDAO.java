package com.leh.principle.compositionandaggregation;

/**
 * @ClassName ProductDAO
 * @Description TODO
 * @Author lveh
 * @Date 2020/6/17 15:37
 * @Version 1.0
 **/
public class ProductDAO {
    private DBConnection dbConnection;

    public void setDbConnection(DBConnection dbConnection){
        this.dbConnection = dbConnection;
    }

    public void addProduct(){
        String conn = dbConnection.getConnection();
        System.out.println("使用" + conn + "增加产品");
    }
}
