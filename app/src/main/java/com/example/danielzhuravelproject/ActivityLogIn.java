package com.example.danielzhuravelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogIn extends AppCompatActivity {

    EditText name;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        name = findViewById(R.id.etLoginName);
        password = findViewById(R.id.etLoginPassword);
    }


    public void toSignUp(View view) {
        Intent i=new Intent(this,ActivitySignUp.class);
        startActivity(i);
    }


    public void logIn(View view) {
        String strName = name.getText().toString();
        String strPassword = password.getText().toString();

        Dal dal = new Dal(this);
        if(dal.userIsExists(strName,strPassword)){
            Intent i=new Intent(this,ActivityMainMenu.class);
            i.putExtra("userid", dal.getUserByName(strName).getId());
            startActivity(i);
        }
        else Toast.makeText(this, "User name or Password are incorrect", Toast.LENGTH_SHORT).show();


    }

}