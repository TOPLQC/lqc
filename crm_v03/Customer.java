package com.wnxy.crm_v03;

public class Customer {
    private String name;
    private boolean sex;
    private String phone;
    private String province;

    public Customer() {
    }

    public Customer(String name, boolean sex, String phone, String province) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.province = province;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", province='" + province + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
