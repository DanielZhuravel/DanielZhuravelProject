package com.example.danielzhuravelproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Summarie {
    private String subject;
    private String fromWho;
    private String whatAbout;
    private Bitmap img;

    public Summarie(String subject, String fromWho, String whatAbout, Context context) {
        subject = subject;
        this.fromWho = fromWho;
        this.whatAbout = whatAbout;
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
        subject = subject;
    }

    public String getFromWho() {
        return fromWho;
    }

    public void setFromWho(String fromWho) {
        this.fromWho = fromWho;
    }

    public String getWhatAbout() {
        return whatAbout;
    }

    public void setWhatAbout(String whatAbout) {
        this.whatAbout = whatAbout;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }
}
