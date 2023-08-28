package com.wnxy.day10;

public class Person {
    public String name;
    public Boolean sex;
    public Integer age;

    public String getInfo() {
        String info = String.format("name=%s,sex=%s,age=%s", this.age, this.sex, this.name);
        return info;
    }
}
