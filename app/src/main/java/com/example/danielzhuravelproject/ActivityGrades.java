package com.example.danielzhuravelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ActivityGrades extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    ListView lstview;
    ArrayList<Grade> arrGrades = new ArrayList<Grade>();
    String gradeSub;
    String gradeNum;
    int actualGrade;
    RadioGroup options;
    EditText gradeDateET;
    View inflater;
    Dal dal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);

        dal= new Dal(this);

        lstview = findViewById(R.id.listViewGrades);

        arrGrades = dal.getAllGradesByID(getIntent().getIntExtra("userid",0));
        GradeAdapter ga = new GradeAdapter(this, R.layout.grade,arrGrades);
        lstview.setAdapter(ga);
    }

//    public void getGradeData() {
//        Grade g = new Grade("Math", 87, "28.6.2005", this);
//
//        arrGrades.add(g);
//        g = new Grade("English",95,"35.9.3004",this);
//        arrGrades.add(g);
//        g = new Grade("PE",100,"1.2.2003",this);
//        arrGrades.add(g);
//    }

    public void addGrade(View view) {
        final Grade g = new Grade();
        final Dal dal = new Dal(this);
        LayoutInflater linf = LayoutInflater.from(this);
        inflater = linf.inflate(R.layout.grade_alert_dialog,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Grade");
        final View customLayout = getLayoutInflater().inflate(R.layout.grade_alert_dialog, null);

        builder.setView(inflater);
        final EditText gradeET = inflater.findViewById(R.id.gradeET);
        final EditText subjectET = inflater.findViewById(R.id.subjectET);
        gradeDateET = inflater.findViewById(R.id.gradeDateET);
        RadioGroup radioGroup = inflater.findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(ActivityGrades.this);
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(gradeET.getText().toString().matches("") || subjectET.getText().toString().matches("") || gradeDateET.getText().toString().matches(""))
                    Toast.makeText(ActivityGrades.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
                else{
                    g.setSubject(subjectET.getText().toString());
                    g.setGrade(Integer.parseInt(gradeET.getText().toString()));
                    g.setDate(gradeDateET.getText().toString());
                    g.setDefaultImg(ActivityGrades.this);
                    arrGrades.add(g);
                    dal.addGrade(subjectET.getText().toString(),Integer.parseInt(gradeET.getText().toString()), gradeDateET.getText().toString(), g.getImg(), getIntent().getIntExtra("usrid",0));

                    GradeAdapter ga = new GradeAdapter(ActivityGrades.this, R.layout.grade,arrGrades);
                    lstview.setAdapter(ga);
                }
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();

//        final Grade g = new Grade();
//        boolean flag = true;
//        Dal dal = new Dal(this);
//        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
//        builder1.setTitle("How much did you get?");
//        final EditText input1 = new EditText(this);
//        LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT);
//        input1.setLayoutParams(lp1);
//        builder1.setView(input1);
//        builder1.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                gradeNum = input1.getText().toString();
//            }
//        });
//        builder1.show();
//        if(input1==null) {
//            flag = false;
//            actualGrade = Integer.parseInt(gradeNum);
//            g.setGrade(actualGrade);
//        }
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Grade in:");
//        final EditText input = new EditText(this);
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT);
//        input.setLayoutParams(lp);
//        builder.setView(input);
//        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                gradeSub = input.getText().toString();
//            }
//        });
//        builder.show();
//        if (input == null)
//            flag = false;
//
//        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
//        builder.setTitle("Was the test today?");
//        final EditText input2 = new EditText(this);
//        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT);
//        input2.setLayoutParams(lp2);
//        builder2.setView(input2);
//        builder2.setPositiveButton("yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Date c = Calendar.getInstance().getTime();
//
//                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
//                String formattedDate = df.format(c);
//
//                g.setDate(formattedDate);
//            }
//        });
//        builder2.setNegativeButton("no", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//
//            }
//        })
//        builder.show();
//
//        if(flag){
//            dal.addGrade(gradeSub, actualGrade, getIntent().getIntExtra("userid",0));
//            arrGrades.add()
//        }


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId == R.id.radioButton8){
            gradeDateET.setEnabled(false);
            Date c = Calendar.getInstance().getTime();

            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
            String formattedDate = df.format(c);

            gradeDateET.setText(""+formattedDate);
        }
        else{
            gradeDateET.setEnabled(true);
            gradeDateET.setText("");
        }
    }
}