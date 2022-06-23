package com.example.bank_manager3.utils;

public class QueryHelper {
    private String select;

    public QueryHelper() {
    }

    //查询单表
    public QueryHelper(int type) {
        switch (type) {
            case 1:
                this.select = "SELECT * FROM FINANCE.CLIENT;";
                break;
            case 2:
                this.select = "SELECT * FROM FINANCE.BANK_CARD;";
                break;
            case 3:
                this.select = "SELECT * FROM FINANCE.FINANCES_PRODUCT;";
                break;
            case 4:
                this.select = "SELECT * FROM FINANCE.FUND;";
                break;
            case 5:
                this.select = "SELECT * FROM FINANCE.INSURANCE;";
                break;
            case 6:
                this.select = "SELECT * FROM FINANCE.PROPERTY;";
                break;
            default:
                break;
        }
    }

    public QueryHelper(String s) {
        this.select = s;
    }

    //获取查询指令
    public String getSelect() {
        return select;
    }
}
