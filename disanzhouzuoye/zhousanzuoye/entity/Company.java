package com.wnxy.disanzhouzuoye.zhousanzuoye.entity;

import com.wnxy.disanzhouzuoye.utils.IdUtil;

public class Company {
    private String id;
    private String name;
    private String boss;
    private int year;

    public Company() {
        setId(IdUtil.createId());
    }

    public Company(String line) {
        String[] items = line.split("-");
        this.id = items[0];
        this.name = items[1];
        this.boss = items[2];
        this.year = Integer.parseInt(items[3]);
    }

    public Company(String id, String name, String boss, int year) {
        this.id = id;
        this.name = name;
        this.boss = boss;
        this.year = year;
    }

    @Override
    public String toString() {
        String[] items = {this.id, this.name, this.boss, String.valueOf(this.year)};
        String message = String.join("-", items);
        return message;
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

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}