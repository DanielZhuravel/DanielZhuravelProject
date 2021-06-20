package com.example.danielzhuravelproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.ByteArrayOutputStream;

public class Summarie {
    private String subject;
    private String whatAbout;
    private String fromWho;
    private byte[] img;

    public Summarie(String subject, String whatAbout, String fromWho, Context context) {
        subject = subject;
        this.whatAbout = whatAbout;
        this.fromWho = fromWho;
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

    public Summarie() {
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

    public String getWhatAbout() {
        return whatAbout;
    }

    public void setWhatAbout(String whatAbout) {
        this.whatAbout = whatAbout;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getFromWho() {
        return fromWho;
    }

    public void setFromWho(String fromWho) {
        this.fromWho = fromWho;
    }
}
