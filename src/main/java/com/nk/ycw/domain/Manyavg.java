package com.nk.ycw.domain;

public class Manyavg {
   private String country;
   private Integer sumnum;
   private Double avgage;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getSumnum() {
        return sumnum;
    }

    public void setSumnum(Integer sumnum) {
        this.sumnum = sumnum;
    }

    public Double getAvgage() {
        return avgage;
    }

    public void setAvgage(Double avgage) {
        this.avgage = avgage;
    }

    public Double getAvgkm() {
        return avgkm;
    }

    public void setAvgkm(Double avgkm) {
        this.avgkm = avgkm;
    }

    private Double avgkm;

    public Manyavg() {
    }

    public Manyavg(String country, Integer sumnum, Double avgage, Double avgkm) {
        this.country = country;
        this.sumnum = sumnum;
        this.avgage = avgage;
        this.avgkm = avgkm;
    }

    @Override
    public String toString() {
        return "Manyavg{" +
                "country='" + country + '\'' +
                ", sumnum=" + sumnum +
                ", avgage=" + avgage +
                ", avgkm=" + avgkm +
                '}';
    }
}
