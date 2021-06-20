package com.example.danielzhuravelproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.ByteArrayOutputStream;

public class Grade {
    private String subject;
    private int grade;
    private String date;
    private byte[] img;

    public Grade(String subject, int grade, String date,Context context) {
        this.subject = subject;
        this.grade = grade;
        this.date = date;
        Drawable d = context.getDrawable(R.drawable.default_subject_img);
        if(this.subject.toLowerCase().matches("math") )
        {d = context.getDrawable(R.drawable.math_subject_img_not_jpg);}
        if(this.subject.toLowerCase().matches("english") )
        {d = context.getDrawable(R.drawable.english_subject_img_not_jpg);}
        if(this.subject.toLowerCase().matches("pe"))
        {d = context.getDrawable(R.drawable.pe_subject_img_not_jpg);}

        Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);

        img = stream.toByteArray();

    }

    public Grade(){

    }

    public void setDefaultImg(Context context){
        Drawable d = context.getDrawable(R.drawable.default_subject_img);
        if(this.subject.toLowerCase().matches("math") )
        {d = context.getDrawable(R.drawable.math_subject_img_not_jpg);}
        if(this.subject.toLowerCase().matches("english") )
        {d = context.getDrawable(R.drawable.english_subject_img_not_jpg);}
        if(this.subject.toLowerCase().matches("pe"))
        {d = context.getDrawable(R.drawable.pe_subject_img_not_jpg);}

        Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);

        img = stream.toByteArray();
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

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
