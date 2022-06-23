package com.example.bank_manager3.bean;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 6/21/2022 - 9:43 AM
 */
public class Fund {
    private int fu_id;
    private String fu_name;
    private String fu_type;
    private int fu_manager;
    private double fu_amount;
    private String fu_risk_level;
    private String buy_link;

    public Fund() {
    }

    public int getFu_id() {
        return fu_id;
    }

    public void setFu_id(int fu_id) {
        this.fu_id = fu_id;
    }

    public String getFu_name() {
        return fu_name;
    }

    public void setFu_name(String fu_name) {
        this.fu_name = fu_name;
    }

    public String getFu_type() {
        return fu_type;
    }

    public void setFu_type(String fu_type) {
        this.fu_type = fu_type;
    }

    public int getFu_manager() {
        return fu_manager;
    }

    public void setFu_manager(int fu_manager) {
        this.fu_manager = fu_manager;
    }

    public double getFu_amount() {
        return fu_amount;
    }

    public void setFu_amount(double fu_amount) {
        this.fu_amount = fu_amount;
    }

    public String getFu_risk_level() {
        return fu_risk_level;
    }

    public void setFu_risk_level(String fu_risk_level) {
        this.fu_risk_level = fu_risk_level;
    }

    public String getBuy_link() {
        return buy_link;
    }

    public void setBuy_link(String buy_link) {
        this.buy_link = buy_link;
    }
}
