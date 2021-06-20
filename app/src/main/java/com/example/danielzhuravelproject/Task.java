package com.example.danielzhuravelproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

/*לעשות שכשלוחצים על הדבר ברשימה אז זה פותח דף עם כל הפרטים על המשימה להגשה ושתיהיה אפשרות למחוק את המשימה מהרשימה אם סיימו אותה*/

public class Task {
    private String subject;
    private String dueDate;
    private String taskTodo;
    private byte[] subjectimg;
    private boolean checkBox;
    private int flag;
    private int taskID;

    public Task(String subject, String dueDate, String taskTodo, Context context) {
        Drawable d = context.getDrawable(R.drawable.default_subject_img);
        this.subject = subject;
        this.dueDate = dueDate;
        this.taskTodo = taskTodo;
        this.checkBox = false;
        if(checkBox)
            flag = 1;
        else flag = 2;
        if(this.subject == "Math")
        {d = context.getDrawable(R.drawable.math_subject_img);}
        if(this.subject == "English")
        {d = context.getDrawable(R.drawable.english_subject_img);}
        if(this.subject == "PE")
        {d = context.getDrawable(R.drawable.pe_subject_img);}

        Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);

        subjectimg = stream.toByteArray();
    }

    public Task() {
        this.checkBox = false;
        this.flag = 1;
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

        subjectimg = stream.toByteArray();
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getTaskTodo() {
        return taskTodo;
    }

    public void setTaskTodo(String taskTodo) {
        this.taskTodo = taskTodo;
    }

    public byte[] getSubjectimg() {
        return subjectimg;
    }

    public boolean isCheckBox() { return checkBox; }

    public void setCheckBox(boolean checkBox) { this.checkBox = checkBox; }

    public void setSubjectimg(byte[] subjectimg) {
        this.subjectimg = subjectimg;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Task{" +
                "subject='" + subject + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", taskTodo='" + taskTodo + '\'' +
                ", subjectimg=" + subjectimg +
                '}';
    }
}
