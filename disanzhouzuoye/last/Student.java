package com.wnxy.disanzhouzuoye.last;

public class Student {

    private String name;
    private Integer age;
    private Integer weight;

    public Student() {
    }

    public Student(String name, Integer age, Integer weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    //compare比较，compareTo和某某进行比较
    //  @Override
//    public int compareTo(Student other) {
//        /**现在是this和other之间的比较
//         * 使用更简单的进行比较
//         * 将两个学院的比较转换为两个学员的姓名的比较*/
//        int res =this.getName().compareTo(other.getName());
//
//        return -res;
//    }
}

