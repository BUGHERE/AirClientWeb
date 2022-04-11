package com.nk.ycw.domain;

public class Datanum {
    private String datebuy;
    private Integer sumnum;

    @Override
    public String toString() {
        return "Datanum{" +
                "datebuy='" + datebuy + '\'' +
                ", sumnum=" + sumnum +
                '}';
    }

    public String getDatebuy() {
        return datebuy;
    }

    public void setDatebuy(String datebuy) {
        this.datebuy = datebuy;
    }

    public Integer getSumnum() {
        return sumnum;
    }

    public void setSumnum(Integer sumnum) {
        this.sumnum = sumnum;
    }

    public Datanum() {
    }

    public Datanum(String datebuy, Integer sumnum) {
        this.datebuy = datebuy;
        this.sumnum = sumnum;
    }
}
