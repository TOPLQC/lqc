package com.wnxy.day17.generic_demo;

public class Student {
    public String name;
    public int weight;

    public Student() {
    }

    public Student(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
