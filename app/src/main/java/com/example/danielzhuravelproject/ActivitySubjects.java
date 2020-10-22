package com.example.danielzhuravelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivitySubjects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);
    }

    public void toHomeWork(View view) {
        Intent i=new Intent(this,ActivityHomeWork.class);
        startActivity(i);
    }

    public void toGrades(View view) {
        Intent i=new Intent(this,ActivityGrades.class);
        startActivity(i);
    }

    public void toSummaries(View view) {
        Intent i=new Intent(this,ActivitySummaries.class);
        startActivity(i);
    }
}