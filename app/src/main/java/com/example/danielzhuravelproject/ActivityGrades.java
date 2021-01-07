package com.example.danielzhuravelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityGrades extends AppCompatActivity {

    ListView lstview;
    ArrayList<Grade> arrGrades = new ArrayList<Grade>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);

        lstview = findViewById(R.id.listViewGrades);

        getGradeData();

        GradeAdapter ga = new GradeAdapter(this, R.layout.grade,arrGrades);
        lstview.setAdapter(ga);
    }

    public void getGradeData() {
        Grade g = new Grade("Math", 87, "28.6.2005", this);

        arrGrades.add(g);
        g = new Grade("English",95,"35,9.3004",this);
        arrGrades.add(g);
        g = new Grade("PE",100,"1.2.2003",this);
        arrGrades.add(g);
    }
}