package com.nk.wyj.domain;

public class First {
    String firstscore;
    String count;

    @Override
    public String toString() {
        return "First{" +
                "firstscore='" + firstscore + '\'' +
                ", count='" + count + '\'' +
                '}';
    }

    public void setFirstscore(String firstscore) {
        this.firstscore = firstscore;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getFirstscore() {
        return firstscore;
    }

    public String getCount() {
        return count;
    }

    public First(String firstscore, String count) {
        this.firstscore = firstscore;
        this.count = count;
    }

    public First() {
    }
}
