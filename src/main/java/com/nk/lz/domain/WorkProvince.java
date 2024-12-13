package com.nk.lz.domain;

public class WorkProvince {
    private String work_province;
    private Integer num;

    @Override
    public String toString() {
        return "WorkProvince{" +
                "work_province='" + work_province + '\'' +
                ", num=" + num +
                '}';
    }

    public String getWork_province() {
        return work_province;
    }

    public void setWork_province(String work_province) {
        this.work_province = work_province;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public WorkProvince() {
    }

    public WorkProvince(String work_province, Integer num) {
        this.work_province = work_province;
        this.num = num;
    }
}
