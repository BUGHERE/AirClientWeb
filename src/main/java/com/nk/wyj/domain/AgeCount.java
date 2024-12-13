package com.nk.wyj.domain;

public class AgeCount {
    String age;
    String count;

    @Override
    public String toString() {
        return "AgeCount{" +
                "age='" + age + '\'' +
                ", count='" + count + '\'' +
                '}';
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getAge() {
        return age;
    }

    public String getCount() {
        return count;
    }

    public AgeCount(String age, String count) {
        this.age = age;
        this.count = count;
    }

    public AgeCount() {
    }
}
