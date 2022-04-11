package com.nk.ycw.domain;

public class Yearcount {
    private Integer first;
    private Integer second;

    public Yearcount(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Yearcount{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Yearcount() {
    }
}
