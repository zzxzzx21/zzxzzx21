package com.example.bank_manager3.bean;

import java.util.ArrayList;
import java.util.List;

public class TableBean {
//    private int id;
    private ArrayList<String> table = new ArrayList<>();

    public TableBean(List<String> stringList) {
        this.table= (ArrayList<String>) stringList;
    }

    public ArrayList<String> getTable() {
        return table;
    }

    public void setTable(ArrayList<String> table) {
        this.table = table;
    }
}
