package com.nk.lz.domain;

public class AvgDiscount {
    private String flight_count_region;
    private Double avg_disc;

    @Override
    public String toString() {
        return "AvgDiscount{" +
                "flight_count_region='" + flight_count_region + '\'' +
                ", avg_disc=" + avg_disc +
                '}';
    }

    public String getFlight_count_region() {
        return flight_count_region;
    }

    public void setFlight_count_region(String flight_count_region) {
        this.flight_count_region = flight_count_region;
    }

    public Double getAvg_disc() {
        return avg_disc;
    }

    public void setAvg_disc(Double avg_disc) {
        this.avg_disc = avg_disc;
    }

    public AvgDiscount() {
    }

    public AvgDiscount(String flight_count_region, Double avg_disc) {
        this.flight_count_region = flight_count_region;
        this.avg_disc = avg_disc;
    }
}
