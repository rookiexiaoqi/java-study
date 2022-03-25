package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws Exception {   //下面方法有不同的异常，我直接抛出一个大的异常

        //1、导入驱动jar包
        //2、注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        /*?useUnicode=true&characterEncoding=gbk*/
        //3、获取数据库的连接对象
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "19981102");

        //4、定义sql语句
        String sql = "insert  Student value('20220606','李安琪',22,'女','1999-2-28')";

        //4、获取执行sql语句的对象
        Statement stat = con.createStatement();

        //5、执行sql并接收返回结果
        int count = stat.executeUpdate(sql);

        //6、处理结果
        System.out.println(count);

        //8、释放资源
        stat.close();
        con.close();
    }
}

