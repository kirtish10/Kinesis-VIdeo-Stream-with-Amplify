package com.example.myapplication.login;

public class User {
    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getIdt() {
        return idt;
    }

    public void setIdt(String idt) {
        this.idt = idt;
    }

    public String getRefresh() {
        return refresh;
    }

    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }

    String access;

    public User(String access, String idt, String refresh) {
        this.access = access;
        this.idt = idt;
        this.refresh = refresh;
    }

    String idt;
    String refresh;
}
