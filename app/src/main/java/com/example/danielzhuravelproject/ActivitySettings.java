package com.example.danielzhuravelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivitySettings extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText password;
    String Name;
    String Email;
    String Password;
    User u;
    Dal dal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        name = findViewById(R.id.nameET);
        email = findViewById(R.id.emailET);
        password = findViewById(R.id.passwordET);

        dal = new Dal(this);

        u = dal.getUserByID(getIntent().getIntExtra("userid",0));

        Name = u.getUsername();
        Email = u.getEmail();
        Password = u.getPassword();

        name.setText(Name);
        email.setText(Email);
        password.setText(Password);


    }

    public void updateProfile(View view) {
        if(name.getText().toString().matches("") || email.getText().toString().matches("") || password.getText().toString().matches("")) {
            Toast.makeText(this, "All fileds must be filled", Toast.LENGTH_SHORT).show();
        }
        else dal.updateUserProfile(name.getText().toString(), email.getText().toString(), password.getText().toString(), getIntent().getIntExtra("userid",0));
    }
}