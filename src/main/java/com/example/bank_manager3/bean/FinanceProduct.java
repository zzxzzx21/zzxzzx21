package com.example.bank_manager3.bean;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 6/21/2022 - 9:17 PM
 */
public class FinanceProduct {
    private int fp_id;
    private String fp_name;
    private String fp_description;
    private double fp_amount;
    private String buy_link;

    public int getFp_id() {
        return fp_id;
    }

    public void setFp_id(int fp_id) {
        this.fp_id = fp_id;
    }

    public String getFp_name() {
        return fp_name;
    }

    public void setFp_name(String fp_name) {
        this.fp_name = fp_name;
    }

    public String getFp_description() {
        return fp_description;
    }

    public void setFp_description(String fp_description) {
        this.fp_description = fp_description;
    }

    public double getFp_amount() {
        return fp_amount;
    }

    public void setFp_amount(double fp_amount) {
        this.fp_amount = fp_amount;
    }

    public String getBuy_link() {
        return buy_link;
    }

    public void setBuy_link(String buy_link) {
        this.buy_link = buy_link;
    }
}
