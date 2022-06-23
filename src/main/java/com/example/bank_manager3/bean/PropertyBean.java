package com.example.bank_manager3.bean;

public class PropertyBean {
    private String pr_id;
    private String pr_c_id;
    private String pr_product_id;
    private String pr_product_type;
    private String pr_product_count;
    private String pr_product_status;
    private String pr_product_income;
    private String pr_product_time;

    public void setInfo(int i, String info) {
        switch (i) {
            case 1:
                this.pr_id = info;
                break;
            case 2:
                this.pr_c_id = info;
                break;
            case 3:
                this.pr_product_id = info;
                break;
            case 4:
                this.pr_product_type = info;
                break;
            case 5:
                this.pr_product_count = info;
                break;
            case 6:
                this.pr_product_status = info;
                break;
            case 7:
                this.pr_product_income = info;
                break;
            case 8:
                this.pr_product_time = info;
                break;
            default:
                break;
        }
    }

    public String getPr_id() {
        return pr_id;
    }

    public void setPr_id(String pr_id) {
        this.pr_id = pr_id;
    }

    public String getPr_c_id() {
        return pr_c_id;
    }

    public void setPr_c_id(String pr_c_id) {
        this.pr_c_id = pr_c_id;
    }

    public String getPr_product_id() {
        return pr_product_id;
    }

    public void setPr_product_id(String pr_product_id) {
        this.pr_product_id = pr_product_id;
    }

    public String getPr_product_type() {
        return pr_product_type;
    }

    public void setPr_product_type(String pr_product_type) {
        this.pr_product_type = pr_product_type;
    }

    public String getPr_product_count() {
        return pr_product_count;
    }

    public void setPr_product_count(String pr_product_count) {
        this.pr_product_count = pr_product_count;
    }

    public String getPr_product_status() {
        return pr_product_status;
    }

    public void setPr_product_status(String pr_product_status) {
        this.pr_product_status = pr_product_status;
    }

    public String getPr_product_income() {
        return pr_product_income;
    }

    public void setPr_product_income(String pr_product_income) {
        this.pr_product_income = pr_product_income;
    }

    public String getPr_product_time() {
        return pr_product_time;
    }

    public void setPr_product_time(String pr_product_time) {
        this.pr_product_time = pr_product_time;
    }
}
