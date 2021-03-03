package com.example.danielzhuravelproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Grade {
    private String subject;
    private int grade;
    private String date;
    private Bitmap img;

    public Grade(String subject, int grade, String date,Context context) {
        this.subject = subject;
        this.grade = grade;
        this.date = date;
        if(this.subject == "Math")
        {this.img = BitmapFactory.decodeResource(context.getResources(),R.drawable.math_subject_img);}
        if(this.subject == "English")
        {this.img = BitmapFactory.decodeResource(context.getResources(),R.drawable.english_subject_img);}
        if(this.subject == "PE")
        {this.img = BitmapFactory.decodeResource(context.getResources(),R.drawable.pe_subject_img);}

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }
}
