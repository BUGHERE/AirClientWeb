package com.nk.lz.domain;

public class Age {
    private String age;
    private Integer num;
    private Integer avg_fc;

    @Override
    public String toString() {
        return "Age{" +
                "age='" + age + '\'' +
                ", num=" + num +
                ", avg_fc=" + avg_fc +
                '}';
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getAvg_fc() {
        return avg_fc;
    }

    public void setAvg_fc(Integer avg_fc) {
        this.avg_fc = avg_fc;
    }

    public Age() {
    }

    public Age(String age, Integer num, Integer avg_fc) {
        this.age = age;
        this.num = num;
        this.avg_fc = avg_fc;
    }
}
