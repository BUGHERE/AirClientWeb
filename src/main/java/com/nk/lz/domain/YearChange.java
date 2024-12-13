package com.nk.lz.domain;

public class YearChange {
    private String ageregion;
    private Double avg_fc1;
    private Double avg_fc2;

    @Override
    public String toString() {
        return "YearChange{" +
                "ageregion='" + ageregion + '\'' +
                ", avg_fc1=" + avg_fc1 +
                ", avg_fc2=" + avg_fc2 +
                '}';
    }

    public String getAgeregion() {
        return ageregion;
    }

    public void setAgeregion(String ageregion) {
        this.ageregion = ageregion;
    }

    public Double getAvg_fc1() {
        return avg_fc1;
    }

    public void setAvg_fc1(Double avg_fc1) {
        this.avg_fc1 = avg_fc1;
    }

    public Double getAvg_fc2() {
        return avg_fc2;
    }

    public void setAvg_fc2(Double avg_fc2) {
        this.avg_fc2 = avg_fc2;
    }

    public YearChange() {
    }

    public YearChange(String ageregion, Double avg_fc1, Double avg_fc2) {
        this.ageregion = ageregion;
        this.avg_fc1 = avg_fc1;
        this.avg_fc2 = avg_fc2;
    }
}
