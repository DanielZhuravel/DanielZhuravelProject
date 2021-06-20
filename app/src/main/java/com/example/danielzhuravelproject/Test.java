package com.example.danielzhuravelproject;

public class Test {
    private String date;
    private String subject;

    public Test(String date, String subject) {
        this.date = date;
        this.subject = subject;
    }

    public Test() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
