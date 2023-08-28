package com.wnxy.day07;

public class Student {
    private String name;
    private boolean sex;
    private String phone;
    private int age;

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 18) {
            age = 18;
        }
        if (age > 30) {
            age = 30;
        }
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public boolean getSex() {
        return this.sex;
    }

    public void setSex(boolean sex) {

        this.sex = sex;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }


    public void introdce() {
        System.out.print("name = " + name);
        System.out.print(", sex = " + sex);
        System.out.print(", age = " + age);
        System.out.print(", phone = " + phone);
    }

    public int add(int a, int b) {
        return a + b;
    }
}