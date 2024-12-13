package com.nk.wyj.domain;

public class Second {
    String secondscore;
    String count;

    @Override
    public String toString() {
        return "Second{" +
                "secondscore='" + secondscore + '\'' +
                ", count='" + count + '\'' +
                '}';
    }

    public void setSecondscore(String secondscore) {
        this.secondscore = secondscore;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getSecondscore() {
        return secondscore;
    }

    public String getCount() {
        return count;
    }

    public Second(String secondscore, String count) {
        this.secondscore = secondscore;
        this.count = count;
    }

    public Second() {
    }
}
