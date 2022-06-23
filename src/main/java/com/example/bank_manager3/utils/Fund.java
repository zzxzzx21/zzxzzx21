package com.example.bank_manager3.utils;

import com.example.bank_manager3.bean.FundBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Fund {
    /*
     * 返回一个包含Client对象的列表
     *
     * */
    private List<FundBean> list;

    public List<FundBean> getList() {
        return list;
    }

    public Fund() {
        List<FundBean> list = new ArrayList<>();
        //连接数据库
        new ConnectDB();
        Connection connection = ConnectDB.getConnect("124.70.25.88", "finance", "26000", "dboper", "Bigdata123");
//        Connection connection = ConnectionOpengauss.getConnect("123.60.55.125", "finance", "26000", "dboper", "Bigdata123");
        if (connection != null) {
//            single_table_select(connection, "websites");//单表查询
            //查询数据库
            try {
                //创建语句对象
                Statement statement = connection.createStatement();
                //查询表格
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM finance." + table + ";");
                ResultSet resultSet = statement.executeQuery("SELECT * FROM finance.fund order by fu_id;");
                //打印结果
                System.out.println("SELECT FROM : Fund");
//                print_results(resultSet);
                //打印查询结果
                try {
                    //查询表对象
                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                    int count = resultSetMetaData.getColumnCount();
//                    ArrayList<String> list_info = new ArrayList<>(count);
//                    for (int i = 1; i <= count; i++) {
//                        list_info.add(resultSetMetaData.getColumnName(i));
//                    }
                    while (resultSet.next()) {
                        FundBean fundBean = new FundBean();

                        for (int j = 1; j <= count; j++) {
                            fundBean.setInfo(j, resultSet.getString(j));
                        }
                        list.add(fundBean);
                    }
                    resultSet.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //查询结束，释放查询资源
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //断开数据库连接
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        this.list = list;
    }

}

