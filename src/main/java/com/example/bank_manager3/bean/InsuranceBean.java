package com.example.bank_manager3.bean;

public class InsuranceBean {
    private String in_name;
    private String in_id;
    private String in_item;
    private String in_suitable_people;
    private String in_amount;

    public InsuranceBean() {
    }

    public void setInfo(int i, String info) {
        //为方便赋值
        switch (i) {
            case 1:
                this.in_id = info;
                break;
            case 2:
                this.in_name = info;
                break;
            case 3:
                this.in_item = info;
                break;
            case 4:
                this.in_suitable_people = info;
                break;
            case 5:
                this.in_amount = info;
                break;
            default:
                break;
        }
    }

    public String getInfo() {
        String info = "";
        info = this.in_id + "  " + this.in_name + "   " + this.in_item + "  " + this.in_suitable_people + "    " + this.in_amount;
        return info;
    }

    public String getIn_name() {
        return in_name;
    }

    public void setIn_name(String in_name) {
        this.in_name = in_name;
    }

    public String getIn_id() {
        return in_id;
    }

    public void setIn_id(String in_id) {
        this.in_id = in_id;
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

    public String getIn_amount() {
        return in_amount;
    }

    public void setIn_amount(String in_amount) {
        this.in_amount = in_amount;
    }
}
