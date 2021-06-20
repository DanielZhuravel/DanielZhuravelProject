package com.example.danielzhuravelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivitySignUp extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.etSignUpName);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etSignUpPassword);
    }


    public void register(View view) {
        String strname = name.getText().toString();
        String stremail = email.getText().toString();
        String strpassword = password.getText().toString();

        Toast.makeText(this, "User name: " + strname + "\nE-mail: " + stremail + "\nPassword: " + strpassword, Toast.LENGTH_SHORT).show();

        Dal dal = new Dal(this);
        dal.addUser(strname,stremail,strpassword);
        User u = dal.getUserByName(strname);
        dal.addDeafultSchedule(u.getId());


        Intent i=new Intent(this,ActivityMainMenu.class);
        startActivity(i);
    }
}