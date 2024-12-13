package com.nk.wyj.domain;

public class Gender {
    String gender;
    String avgLevel;
    String avgAge;

    @Override
    public String toString() {
        return "Gender{" +
                "gender='" + gender + '\'' +
                ", avgLevel='" + avgLevel + '\'' +
                ", avgAge='" + avgAge + '\'' +
                '}';
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAvgLevel(String avgLevel) {
        this.avgLevel = avgLevel;
    }

    public void setAvgAge(String avgAge) {
        this.avgAge = avgAge;
    }

    public String getGender() {
        return gender;
    }

    public String getAvgLevel() {
        return avgLevel;
    }

    public String getAvgAge() {
        return avgAge;
    }

    public Gender(String gender, String avgLevel, String avgAge) {
        this.gender = gender;
        this.avgLevel = avgLevel;
        this.avgAge = avgAge;
    }

    public Gender() {
    }
}
