package com.example.bank_manager3.bean;

public class ManagerFinancesProductBean {
    private String fp_id;
    private String fp_name;
    private String fp_description;
    private String fp_amount;

    public ManagerFinancesProductBean() {
    }

    public void setInfo(int i, String info) {
        //为方便赋值
        switch (i) {
            case 1:
                this.fp_id = info;
                break;
            case 2:
                this.fp_name = info;
                break;
            case 3:
                this.fp_description = info;
                break;
            case 4:
                this.fp_amount = info;
                break;
            default:
                break;
        }
    }

    public String getInfo() {
        String info = "";
        info = this.fp_id + "  " + this.fp_name + "   " + this.fp_description + "  " + this.fp_amount;
        return info;
    }

    public String getFp_id() {
        return fp_id;
    }

    public void setFp_id(String fp_id) {
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

    public String getFp_amount() {
        return fp_amount;
    }

    public void setFp_amount(String fp_amount) {
        this.fp_amount = fp_amount;
    }
}
