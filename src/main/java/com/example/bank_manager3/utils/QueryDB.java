package com.example.bank_manager3.utils;


import com.example.bank_manager3.bean.TableBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryDB {
    private Connection connection;
    private Statement statement;

    private ResultSet resultSet;

    private ArrayList<String> tableHead;

    public QueryDB(String select) {
        new ConnectDB();
        this.connection = ConnectDB.getConnect("124.70.25.88", "finance", "26000", "dboper", "Bigdata123");
//        Connection connection = ConnectionOpengauss.getConnect("123.60.55.125", "finance", "26000", "dboper", "Bigdata123");
        //查询数据库,返回一个查询对象
        if (connection != null) {
            try {
                //创建语句对象
                this.statement = connection.createStatement();
                //查询表格
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM finance." + table + ";");
                this.resultSet = statement.executeQuery(select);

                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int count = resultSetMetaData.getColumnCount();
                this.tableHead = new ArrayList<>(count);
                for (int i = 1; i <= count; i++) {
                    tableHead.add(resultSetMetaData.getColumnName(i));
                }
                //打印结果
//                System.out.println("SELECT FROM : " + select);
//                print_results(resultSet);
//                //查询结束，释放资源
//                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public ArrayList<String> getTableHead() {
//        //打印表头
//        for (String s : list) {
//            System.out.print(s + "      ");
//        }
//        System.out.println();
        return this.tableHead;
    }

    public List<TableBean> getTable() {
        //打印查询结果
        List<TableBean> tableBeanList = new ArrayList<>();
        try {
//            //查询表对象
//            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//            int count = resultSetMetaData.getColumnCount();
//            ArrayList<String> list = new ArrayList<>(count);
//            for (int i = 1; i <= count; i++) {
//                list.add(resultSetMetaData.getColumnName(i));
//            }
//            this.tableHead=list
            //打印表格元素
//            while (resultSet.next()) {//隐含步骤：跳到下一行
//                //打印当前行每列元素，以Tab分隔
//                for (int j = 1; j <= list.size(); j++) {
//                    System.out.print(resultSet.getString(j) + "    ");
//                }
//                System.out.println();
//            }
            while (resultSet.next()) {
                List<String> stringList = new ArrayList<>();
                for (int j = 1; j <= tableHead.size(); j++) {
                    stringList.add(resultSet.getString(j));
                }
                tableBeanList.add(new TableBean(stringList));
            }
            resultSet.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return tableBeanList;
    }
}

