package com.example.danielzhuravelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityCalendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }

    public void toTests(View view) {
        Intent i=new Intent(this,ActivityTests.class);
        startActivity(i);
    }

    public void toTasks(View view) {
        Intent i=new Intent(this,ActivityTasks.class);
        startActivity(i);
    }
}