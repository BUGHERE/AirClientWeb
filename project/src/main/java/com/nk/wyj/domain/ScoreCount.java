package com.nk.wyj.domain;

public class ScoreCount {
    String firstscore;
    String firstcount;
    String secondscore;
    String secondcount;

    @Override
    public String toString() {
        return "ScoreCount{" +
                "firstscore='" + firstscore + '\'' +
                ", firstcount='" + firstcount + '\'' +
                ", secondscore='" + secondscore + '\'' +
                ", secondcount='" + secondcount + '\'' +
                '}';
    }

    public void setFirstscore(String firstscore) {
        this.firstscore = firstscore;
    }

    public void setFirstcount(String firstcount) {
        this.firstcount = firstcount;
    }

    public void setSecondscore(String secondscore) {
        this.secondscore = secondscore;
    }

    public void setSecondcount(String secondcount) {
        this.secondcount = secondcount;
    }

    public String getFirstscore() {
        return firstscore;
    }

    public String getFirstcount() {
        return firstcount;
    }

    public String getSecondscore() {
        return secondscore;
    }

    public String getSecondcount() {
        return secondcount;
    }

    public ScoreCount(String firstscore, String firstcount, String secondscore, String secondcount) {
        this.firstscore = firstscore;
        this.firstcount = firstcount;
        this.secondscore = secondscore;
        this.secondcount = secondcount;
    }

    public ScoreCount() {
    }
}
