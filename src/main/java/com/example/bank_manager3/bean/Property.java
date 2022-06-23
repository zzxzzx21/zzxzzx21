package com.example.bank_manager3.bean;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 6/22/2022 - 9:11 AM
 */
public class Property {
    private int pr_id;
    private int pr_c_id;
    private int pr_product_id;
    private int pr_product_type;
    private int pr_product_count;
    private  String pr_product_status;
    private double pr_product_income;
    private String pr_product_time;

    public int getPr_id() {
        return pr_id;
    }

    public void setPr_id(int pr_id) {
        this.pr_id = pr_id;
    }

    public int getPr_c_id() {
        return pr_c_id;
    }

    public void setPr_c_id(int pr_c_id) {
        this.pr_c_id = pr_c_id;
    }

    public int getPr_product_id() {
        return pr_product_id;
    }

    public void setPr_product_id(int pr_product_id) {
        this.pr_product_id = pr_product_id;
    }

    public int getPr_product_type() {
        return pr_product_type;
    }

    public void setPr_product_type(int pr_product_type) {
        this.pr_product_type = pr_product_type;
    }

    public int getPr_product_count() {
        return pr_product_count;
    }

    public void setPr_product_count(int pr_product_count) {
        this.pr_product_count = pr_product_count;
    }

    public String getPr_product_status() {
        return pr_product_status;
    }

    public void setPr_product_status(String pr_product_status) {
        this.pr_product_status = pr_product_status;
    }

    public double getPr_product_income() {
        return pr_product_income;
    }

    public void setPr_product_income(double pr_product_income) {
        this.pr_product_income = pr_product_income;
    }

    public String getPr_product_time() {
        return pr_product_time;
    }

    public void setPr_product_time(String pr_product_time) {
        this.pr_product_time = pr_product_time;
    }
}
