package com.example.danielzhuravelproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/*לעשות שכשלוחצים על הדבר ברשימה אז זה פותח דף עם כל הפרטים על המשימה להגשה ושתיהיה אפשרות למחוק את המשימה מהרשימה אם סיימו אותה*/

public class Task {
    private String subject;
    private String dueDate;
    private String taskTodo;
    private Bitmap subjectimg;
    private boolean checkBox;

    public Task(String subject, String dueDate, String taskTodo, boolean checkBox, Context context) {
        this.subject = subject;
        this.dueDate = dueDate;
        this.taskTodo = taskTodo;
        this.checkBox = checkBox;
        if(this.subject == "Math")
        {this.subjectimg = BitmapFactory.decodeResource(context.getResources(),R.drawable.math_subject_img);}
        if(this.subject == "English")
        {this.subjectimg= BitmapFactory.decodeResource(context.getResources(),R.drawable.english_subject_img);}
        if(this.subject == "PE")
        {this.subjectimg = BitmapFactory.decodeResource(context.getResources(),R.drawable.pe_subject_img);}
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

    public Bitmap getSubjectimg() {
        return subjectimg;
    }

    public boolean isCheckBox() { return checkBox; }

    public void setCheckBox(boolean checkBox) { this.checkBox = checkBox; }

    public void setSubjectimg(Bitmap subjectimg) {
        this.subjectimg = subjectimg;
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
