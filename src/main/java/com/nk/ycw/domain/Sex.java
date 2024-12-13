package com.nk.ycw.domain;

public class Sex {
    private String gender;
    private Integer sumnum;

    @Override
    public String toString() {
        return "Sex{" +
                "gender='" + gender + '\'' +
                ", sumnum=" + sumnum +
                '}';
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getSumnum() {
        return sumnum;
    }

    public void setSumnum(Integer sumnum) {
        this.sumnum = sumnum;
    }

    public Sex() {
    }

    public Sex(String gender, Integer sumnum) {
        this.gender = gender;
        this.sumnum = sumnum;
    }
}

