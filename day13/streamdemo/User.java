package com.wnxy.day13.streamdemo;

public class User {
    private String id; //编号，必须唯一，身份证号码
    private String name;
    private Boolean sex;
    private Integer age;
    private String province;

    public User() {
    }

    public User(String id, String name, Boolean sex, Integer age, String province) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.province = province;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + (sex ? "男" : "女") +
                ", age=" + age +
                ", province='" + province + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}