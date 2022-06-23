package com.example.bank_manager3.bean;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 6/22/2022 - 8:41 AM
 */
public class BankCard {
    private String bc_number;
    private String bc_type;
    private double bc_balance;
    private String bc_status;
    private int bc_c_id;
    private double bc_overdraft;

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

    public double getBc_balance() {
        return bc_balance;
    }

    public void setBc_balance(double bc_balance) {
        this.bc_balance = bc_balance;
    }

    public String getBc_status() {
        return bc_status;
    }

    public void setBc_status(String bc_status) {
        this.bc_status = bc_status;
    }

    public int getBc_c_id() {
        return bc_c_id;
    }

    public void setBc_c_id(int bc_c_id) {
        this.bc_c_id = bc_c_id;
    }

    public double getBc_overdraft() {
        return bc_overdraft;
    }

    public void setBc_overdraft(double bc_overdraft) {
        this.bc_overdraft = bc_overdraft;
    }
}
