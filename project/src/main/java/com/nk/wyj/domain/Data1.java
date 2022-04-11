package com.nk.wyj.domain;

public class Data1 {
    String FLIGHT_COUNT;
    String P1Y_Flight_Count;
    String SUM_YR_1;
    String L1Y_Flight_Count;
    String SUM_YR_2;
    String Points_Sum;

    @Override
    public String toString() {
        return "Data1{" +
                "FLIGHT_COUNT='" + FLIGHT_COUNT + '\'' +
                ", P1Y_Flight_Count='" + P1Y_Flight_Count + '\'' +
                ", SUM_YR_1='" + SUM_YR_1 + '\'' +
                ", L1Y_Flight_Count='" + L1Y_Flight_Count + '\'' +
                ", SUM_YR_2='" + SUM_YR_2 + '\'' +
                ", Points_Sum='" + Points_Sum + '\'' +
                '}';
    }

    public void setFLIGHT_COUNT(String FLIGHT_COUNT) {
        this.FLIGHT_COUNT = FLIGHT_COUNT;
    }

    public void setP1Y_Flight_Count(String p1Y_Flight_Count) {
        P1Y_Flight_Count = p1Y_Flight_Count;
    }

    public void setSUM_YR_1(String SUM_YR_1) {
        this.SUM_YR_1 = SUM_YR_1;
    }

    public void setL1Y_Flight_Count(String l1Y_Flight_Count) {
        L1Y_Flight_Count = l1Y_Flight_Count;
    }

    public void setSUM_YR_2(String SUM_YR_2) {
        this.SUM_YR_2 = SUM_YR_2;
    }

    public void setPoints_Sum(String points_Sum) {
        Points_Sum = points_Sum;
    }

    public String getFLIGHT_COUNT() {
        return FLIGHT_COUNT;
    }

    public String getP1Y_Flight_Count() {
        return P1Y_Flight_Count;
    }

    public String getSUM_YR_1() {
        return SUM_YR_1;
    }

    public String getL1Y_Flight_Count() {
        return L1Y_Flight_Count;
    }

    public String getSUM_YR_2() {
        return SUM_YR_2;
    }

    public String getPoints_Sum() {
        return Points_Sum;
    }

    public Data1(String FLIGHT_COUNT, String p1Y_Flight_Count, String SUM_YR_1, String l1Y_Flight_Count, String SUM_YR_2, String points_Sum) {
        this.FLIGHT_COUNT = FLIGHT_COUNT;
        P1Y_Flight_Count = p1Y_Flight_Count;
        this.SUM_YR_1 = SUM_YR_1;
        L1Y_Flight_Count = l1Y_Flight_Count;
        this.SUM_YR_2 = SUM_YR_2;
        Points_Sum = points_Sum;
    }

    public Data1() {
    }
}
