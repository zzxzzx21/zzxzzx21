package com.example.bank_manager3.bean;

public class BankCardBean {
    private String bc_number;
    private String bc_type;
    private String bc_balance;
    private String bc_status;
    private String bc_c_id;
    private String bc_overdraft;

    public void setInfo(int i, String info) {
        switch (i) {
            case 1:
                this.bc_number = info;
                break;
            case 2:
                this.bc_type = info;
                break;
            case 3:
                this.bc_balance = info;
                break;
            case 4:
                this.bc_status = info;
                break;
            case 5:
                this.bc_c_id = info;
                break;
            case 6:
                this.bc_overdraft = info;
                break;
            default:
                break;
        }
    }

    public String getBc_number() {
        return bc_number;
    }

    public void setBc_number(String bc_number) {
        this.bc_number = bc_number;
    }

    public String getBc_type() {
        return bc_type;
    }

    public void setBc_type(String bc_type) {
        this.bc_type = bc_type;
    }

    public String getBc_balance() {
        return bc_balance;
    }

    public void setBc_balance(String bc_balance) {
        this.bc_balance = bc_balance;
    }

    public String getBc_status() {
        return bc_status;
    }

    public void setBc_status(String bc_status) {
        this.bc_status = bc_status;
    }

    public String getBc_c_id() {
        return bc_c_id;
    }

    public void setBc_c_id(String bc_c_id) {
        this.bc_c_id = bc_c_id;
    }

    public String getBc_overdraft() {
        return bc_overdraft;
    }

    public void setBc_overdraft(String bc_overdraft) {
        this.bc_overdraft = bc_overdraft;
    }
}
