package com.nk.wyj.domain;

public class GenderLeiDa {
    String FFP_TIER;
    String age;
    String FLIGHT_COUNT;
    String AVG_INTERVAL;
    String avg_discount;
    String Points_Sum;

    public void setFFP_TIER(String FFP_TIER) {
        this.FFP_TIER = FFP_TIER;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setFLIGHT_COUNT(String FLIGHT_COUNT) {
        this.FLIGHT_COUNT = FLIGHT_COUNT;
    }

    public void setAVG_INTERVAL(String AVG_INTERVAL) {
        this.AVG_INTERVAL = AVG_INTERVAL;
    }

    public void setAvg_discount(String avg_discount) {
        this.avg_discount = avg_discount;
    }

    public void setPoints_Sum(String points_Sum) {
        Points_Sum = points_Sum;
    }

    public GenderLeiDa(String FFP_TIER, String age, String FLIGHT_COUNT, String AVG_INTERVAL, String avg_discount, String points_Sum) {
        this.FFP_TIER = FFP_TIER;
        this.age = age;
        this.FLIGHT_COUNT = FLIGHT_COUNT;
        this.AVG_INTERVAL = AVG_INTERVAL;
        this.avg_discount = avg_discount;
        Points_Sum = points_Sum;
    }

    public String getFFP_TIER() {
        return FFP_TIER;
    }

    public String getAge() {
        return age;
    }

    public String getFLIGHT_COUNT() {
        return FLIGHT_COUNT;
    }

    public String getAVG_INTERVAL() {
        return AVG_INTERVAL;
    }

    public String getAvg_discount() {
        return avg_discount;
    }

    public String getPoints_Sum() {
        return Points_Sum;
    }

    public GenderLeiDa() {
    }

    @Override
    public String toString() {
        return "GenderLeiDa{" +
                "FFP_TIER='" + FFP_TIER + '\'' +
                ", age='" + age + '\'' +
                ", FLIGHT_COUNT='" + FLIGHT_COUNT + '\'' +
                ", AVG_INTERVAL='" + AVG_INTERVAL + '\'' +
                ", avg_discount='" + avg_discount + '\'' +
                ", Points_Sum='" + Points_Sum + '\'' +
                '}';
    }
}
