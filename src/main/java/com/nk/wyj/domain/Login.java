package com.nk.wyj.domain;

public class Login {
    String name;
    String passwd;

    @Override
    public String toString() {
        return "Login{" +
                "name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public String getPasswd() {
        return passwd;
    }

    public Login(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    public Login() {
    }
}
