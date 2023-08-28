package com.wnxy.day10;

public class Policeman extends Person {
    public String rank;

    public String getPolicemanInfo() {
        String info = getInfo();
        return String.format("%s,rank=%s", info, this.rank);

    }
}
