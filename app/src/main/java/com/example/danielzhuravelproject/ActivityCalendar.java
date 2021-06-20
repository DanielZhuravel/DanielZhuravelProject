package com.example.danielzhuravelproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityCalendar extends AppCompatActivity implements CalendarView.OnDateChangeListener{
    CalendarView calendar;
    int DayOfMonth;
    int Month;
    int Year;
    Dal dal;
    String date;
    Button addTestbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        dal = new Dal(this);
        addTestbtn = findViewById(R.id.addTest);

        calendar = findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(this);
    }

    public void showTestAlertDialog(View view) {
        String str = "";//להוציא מהמסד נתונים את השם של המקצוע בו יש מבחן באותו יום
        if(dal.checkTest(date,getIntent().getIntExtra("userid",0)))
        {
            str = dal.getTestByDateandID(date, getIntent().getIntExtra("userid",0));
        }
        else str = "No test on this day";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Test in:"+date);
        builder.setMessage(str);
        builder.setPositiveButton("Got it",null);
        AlertDialog mDialog = builder.create();
        mDialog.show();
    }

    public void toTasks(View view) {
        Intent i=new Intent(this,ActivityTasks.class);
        i.putExtra("userid", getIntent().getIntExtra("userid",0));
        startActivity(i);
    }

    @Override
    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
        DayOfMonth = dayOfMonth;
        Month=month;
        Year = year;
        date = dayOfMonth+".";
        if(month<9)
            date+= "0"+(month+1)+"."+year;
        else date += (month+1)+"."+year;

        if(dal.checkTest(date, getIntent().getIntExtra("userid",0))){
            addTestbtn.setEnabled(false);
        }
        else addTestbtn.setEnabled(true);
    }

    public void testAlertDialog(View view){

    }

    public void addTest(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add test in:"+date);
        builder.setMessage("Test's subject:");
        final EditText input1 = new EditText(this);
        LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input1.setLayoutParams(lp1);
        builder.setView(input1);
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(input1.getText().toString().matches("")) {
                    Toast.makeText(ActivityCalendar.this, "The test must have a subject", Toast.LENGTH_SHORT).show();
                }
                else dal.addTest(date,input1.getText().toString(), getIntent().getIntExtra("userid",0));
            }
        });
        builder.show();
    }
}