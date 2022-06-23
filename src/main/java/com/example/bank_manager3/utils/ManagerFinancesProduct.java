package com.example.bank_manager3.utils;

import com.example.bank_manager3.bean.ManagerFinancesProductBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerFinancesProduct {
    private List<ManagerFinancesProductBean> list;

    public List<ManagerFinancesProductBean> getList() {
        return list;
    }

    public ManagerFinancesProduct() {
        List<ManagerFinancesProductBean> list = new ArrayList<>();
        //连接数据库
        new ConnectDB();
        Connection connection = ConnectDB.getConnect("124.70.25.88", "finance", "26000", "dboper", "Bigdata123");
        if (connection != null) {
            //查询数据库
            try {
                //创建语句对象
                Statement statement = connection.createStatement();
                //查询表格
                ResultSet resultSet = statement.executeQuery("SELECT * FROM finance.finances_product order by fp_id;");
                //打印结果
                System.out.println("SELECT FROM : finances_product");
//                print_results(resultSet);
                //打印查询结果
                try {
                    //查询表对象
                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                    int count = resultSetMetaData.getColumnCount();
                    while (resultSet.next()) {
                        ManagerFinancesProductBean financesProductBean = new ManagerFinancesProductBean();
                        for (int j = 1; j <= count; j++) {
                            financesProductBean.setInfo(j, resultSet.getString(j));
                        }
                        list.add(financesProductBean);
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

