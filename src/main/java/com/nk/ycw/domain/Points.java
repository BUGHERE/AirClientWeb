package com.nk.ycw.domain;

public class Points {
    private Integer fcount;
    private Integer points;
    private Integer mem;

    public Points(Integer fcount, Integer points, Integer mem) {
        this.fcount = fcount;
        this.points = points;
        this.mem = mem;
    }

    @Override
    public String toString() {
        return "Points{" +
                "fcount=" + fcount +
                ", points=" + points +
                ", mem=" + mem +
                '}';
    }

    public Integer getFcount() {
        return fcount;
    }

    public void setFcount(Integer fcount) {
        this.fcount = fcount;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getMem() {
        return mem;
    }

    public void setMem(Integer mem) {
        this.mem = mem;
    }

    public Points() {
    }
}
