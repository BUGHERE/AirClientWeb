package com.nk.lz.domain;

public class Region {
    private String name;
    private Integer value;

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Region() {
    }

    public Region(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}
