package com.example.danielzhuravelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityMainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void toSchedule(View view) {
        Intent i=new Intent(this,ActivitySchedule.class);
        startActivity(i);
    }

    public void toCalendar(View view) {
        Intent i=new Intent(this,ActivityCalendar.class);
        startActivity(i);
    }

    public void toSummaries(View view) {
        Intent i=new Intent(this,ActivitySummaries.class);
        startActivity(i);
    }
}