package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws Exception {   //���淽���в�ͬ���쳣����ֱ���׳�һ������쳣

        //1����������jar��
        //2��ע������
        Class.forName("com.mysql.jdbc.Driver");
        /*?useUnicode=true&characterEncoding=gbk*/
        //3����ȡ���ݿ�����Ӷ���
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "19981102");

        //4������sql���
        String sql = "insert  Student value('20220606','���',22,'Ů','1999-2-28')";

        //4����ȡִ��sql���Ķ���
        Statement stat = con.createStatement();

        //5��ִ��sql�����շ��ؽ��
        int count = stat.executeUpdate(sql);

        //6��������
        System.out.println(count);

        //8���ͷ���Դ
        stat.close();
        con.close();
    }
}

