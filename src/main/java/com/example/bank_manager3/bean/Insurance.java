package com.example.bank_manager3.bean;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 6/21/2022 - 8:39 PM
 */
public class Insurance {
    private int in_id;
    private String in_name;
    private double in_amount;
    private String in_item;
    private String in_suitable_people;
    private String buy_link;

    public int getIn_id() {
        return in_id;
    }

    public void setIn_id(int in_id) {
        this.in_id = in_id;
    }

    public String getIn_name() {
        return in_name;
    }

    public void setIn_name(String in_name) {
        this.in_name = in_name;
    }

    public double getIn_amount() {
        return in_amount;
    }

    public void setIn_amount(double in_amount) {
        this.in_amount = in_amount;
    }

    public String getIn_item() {
        return in_item;
    }

    public void setIn_item(String in_item) {
        this.in_item = in_item;
    }

    public String getIn_suitable_people() {
        return in_suitable_people;
    }

    public void setIn_suitable_people(String in_suitable_people) {
        this.in_suitable_people = in_suitable_people;
    }

    public String getBuy_link() {
        return buy_link;
    }

    public void setBuy_link(String buy_link) {
        this.buy_link = buy_link;
    }
}
