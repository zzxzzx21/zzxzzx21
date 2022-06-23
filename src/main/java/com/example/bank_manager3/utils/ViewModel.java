package com.example.bank_manager3.utils;

import com.example.bank_manager3.bean.TableBean;

import java.util.ArrayList;
import java.util.List;

public class ViewModel {
    private final QueryDB queryDB;

    public ViewModel() {
        this.queryDB = new QueryDB("SELECT * FROM finance.client;");
    }

    public ViewModel(String select) {
        this.queryDB = new QueryDB(select);
    }

    public ArrayList<String> getTableHead() {
        //打印表头
        ArrayList<String> tableHead;
        tableHead = queryDB.getTableHead();
        return tableHead;
    }

    public List<TableBean> getTable() {
        List<TableBean> table;
        table = queryDB.getTable();
        return table;
    }

}
