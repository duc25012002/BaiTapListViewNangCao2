package com.hdcompany.android02b1.listviewnangcaobai2.model;

public class Flag {
    private String flag_name;
    private String money;

    private int image;

    public Flag(String s, String toString) {
    }

    public Flag(String flag_name, String money, int image) {
        this.flag_name = flag_name;
        this.money = money;
        this.image = image;
    }


    public String getFlag_name() {
        return flag_name;
    }

    public void setFlag_name(String flag_name) {
        this.flag_name = flag_name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
