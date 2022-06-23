package com.example.bank_manager3.bean;

public class ClientBean {
    private String name;
    private String id;
    private String phone;
    private String id_card;
    private String password;

    public ClientBean() {
    }

    public void setInfo(int i, String info) {
        //为方便赋值
        switch (i) {
            case 1:
                this.id = info;
                break;
            case 2:
                this.name = info;
                break;
            case 3:
                this.phone = info;
                break;
            case 4:
                this.id_card = info;
                break;
            case 5:
                this.password = info;
                break;
            default:
                break;
        }
    }

    public String getInfo() {
        String info = "";
        info = this.id + "  " + this.name + "   " + this.phone + "  " + this.id_card + "    " + this.password;
        return info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
