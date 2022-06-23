package com.example.bank_manager3.bean;

public class FundBean {
    private String fu_id;
    private String fu_name;
    private String fu_type;
    private String fu_manager;
    private String fu_risk_level;
    private String fu_amount;

    public void setInfo(int i, String info) {
        switch (i) {
            case 1:
                this.fu_id = info;
                break;
            case 2:
                this.fu_name = info;
                break;
            case 3:
                this.fu_type = info;
                break;
            case 4:
                this.fu_manager = info;
                break;
            case 5:
                this.fu_risk_level = info;
                break;
            case 6:
                this.fu_amount = info;
                break;
            default:
                break;
        }
    }

    public String getFu_id() {
        return fu_id;
    }

    public void setFu_id(String fu_id) {
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

    public String getFu_manager() {
        return fu_manager;
    }

    public void setFu_manager(String fu_manager) {
        this.fu_manager = fu_manager;
    }

    public String getFu_risk_level() {
        return fu_risk_level;
    }

    public void setFu_risk_level(String fu_risk_level) {
        this.fu_risk_level = fu_risk_level;
    }

    public String getFu_amount() {
        return fu_amount;
    }

    public void setFu_amount(String fu_amount) {
        this.fu_amount = fu_amount;
    }
}
