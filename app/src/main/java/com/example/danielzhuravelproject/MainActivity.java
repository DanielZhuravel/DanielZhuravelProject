package com.example.danielzhuravelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toMainMenu(View view) {
        Intent i=new Intent(this,ActivityMainMenu.class);
        startActivity(i);
    }

    public void toLogIn(View view) {
        Intent i=new Intent(this,ActivityLogIn.class);
        startActivity(i);
    }

    public void toSignUp(View view) {
        Intent i=new Intent(this,ActivitySignUp.class);
        startActivity(i);
    }
}