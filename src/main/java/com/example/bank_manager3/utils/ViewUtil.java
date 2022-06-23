package com.example.bank_manager3.utils;

import com.example.bank_manager3.bean.TableBean;

import java.util.ArrayList;
import java.util.List;

public class ViewUtil {
    private final ViewModel viewModel;

    public ViewUtil() {
        this.viewModel = new ViewModel();
    }

    public ViewUtil(String select) {
        this.viewModel = new ViewModel(select);
    }

    public List<String> PrintTableHead() {
        return viewModel.getTableHead();
    }

    public List<String> PrintTable() {
        List<TableBean> list = viewModel.getTable();
        ArrayList<String> tables = new ArrayList<>();
        for (TableBean table : list) {
            ArrayList<String> info;
            info = table.getTable();
            //                System.out.print(string);
            tables.addAll(info);

        }
        return tables;
    }
}
