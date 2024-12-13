package com.nk.wyj.domain;

public class CityMax10 {
    String WORK_CITY;
    String count;

    @Override
    public String toString() {
        return "CityMax10{" +
                "WORK_CITY='" + WORK_CITY + '\'' +
                ", count='" + count + '\'' +
                '}';
    }

    public void setWORK_CITY(String WORK_CITY) {
        this.WORK_CITY = WORK_CITY;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getWORK_CITY() {
        return WORK_CITY;
    }

    public String getCount() {
        return count;
    }

    public CityMax10(String WORK_CITY, String count) {
        this.WORK_CITY = WORK_CITY;
        this.count = count;
    }

    public CityMax10() {
    }
}
