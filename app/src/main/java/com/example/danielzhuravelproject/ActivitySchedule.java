package com.example.danielzhuravelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class ActivitySchedule extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner sp;
    int day;
    ArrayList<ArrayList<ScheduleSubject>> schedules;
    ListView list;
    Dal dal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);



        sp = findViewById(R.id.sp1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.days_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(this);

        schedules = new ArrayList<>();
        schedules.add(new ArrayList<ScheduleSubject>());
        schedules.add(new ArrayList<ScheduleSubject>());
        schedules.add(new ArrayList<ScheduleSubject>());
        schedules.add(new ArrayList<ScheduleSubject>());
        schedules.add(new ArrayList<ScheduleSubject>());
        schedules.add(new ArrayList<ScheduleSubject>());

        list = findViewById(R.id.schduleLV);

        dal = new Dal(this);

        updateList(sp.getSelectedItemPosition());

        Toast.makeText(this, ""+sp.getSelectedItemPosition(), Toast.LENGTH_SHORT).show();

    }

    public void toSubjects(View view) {
        Intent i=new Intent(this,ActivitySubjects.class);
        startActivity(i);
    }

    public int getDayNum(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_WEEK);
    }


    public void showTodayScheduleAlertDialog(View view) {
        Toast.makeText(this, "day:"+sp.getSelectedItemPosition()+1+" userID:"+getIntent().getIntExtra("userid", 0)+"", Toast.LENGTH_SHORT).show();
        ArrayList<ScheduleSubject>  SLarr = dal.getDayschedule(sp.getSelectedItemPosition()+1,getIntent().getIntExtra("userid", 0));
        LayoutInflater linf = LayoutInflater.from(this);
        final View inflater = linf.inflate(R.layout.custom_layout,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Edit "+sp.getSelectedItem()+" Schedule");
        final View customLayout = getLayoutInflater().inflate(R.layout.custom_layout, null);

        builder.setView(inflater);
        EditText editText = inflater.findViewById(R.id.firstLesson);
        editText.setText(SLarr.get(0).getName());
        editText = inflater.findViewById(R.id.secodLesson);
        editText.setText(SLarr.get(1).getName());
        editText = inflater.findViewById(R.id.thirdLesson);
        editText.setText(SLarr.get(2).getName());
        editText = inflater.findViewById(R.id.fourthLesson);
        editText.setText(SLarr.get(3).getName());
        editText = inflater.findViewById(R.id.fithLesson);
        editText.setText(SLarr.get(4).getName());
        editText = inflater.findViewById(R.id.sixthLesson);
        editText.setText(SLarr.get(5).getName());
        editText = inflater.findViewById(R.id.seventhLesson);
        editText.setText(SLarr.get(6).getName());
        editText = inflater.findViewById(R.id.eighthLesson);
        editText.setText(SLarr.get(7).getName());
        editText = inflater.findViewById(R.id.ninethLesson);
        editText.setText(SLarr.get(8).getName());
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                schedules.get(day).clear();
                EditText et = inflater.findViewById(R.id.firstLesson);
                int day = sp.getSelectedItemPosition();
                if(et.getText()!=null)
                    dal.updateScheduleSubject(day, 1, getIntent().getIntExtra("userid",0), et.getText().toString());
                else dal.updateScheduleSubject(day, 1, getIntent().getIntExtra("userid",0), "");
                et = inflater.findViewById(R.id.secodLesson);
                if(et.getText()!=null)
                    dal.updateScheduleSubject(day, 2, getIntent().getIntExtra("userid",0), et.getText().toString());
                else dal.updateScheduleSubject(day, 2, getIntent().getIntExtra("userid",0), "");
                et = inflater.findViewById(R.id.thirdLesson);
                if(et.getText()!=null)
                    dal.updateScheduleSubject(day, 3, getIntent().getIntExtra("userid",0), et.getText().toString());
                else dal.updateScheduleSubject(day, 3, getIntent().getIntExtra("userid",0), "");
                et = inflater.findViewById(R.id.fourthLesson);
                if(et.getText()!=null)
                    dal.updateScheduleSubject(day, 4, getIntent().getIntExtra("userid",0), et.getText().toString());
                else dal.updateScheduleSubject(day, 4, getIntent().getIntExtra("userid",0), "");
                et = inflater.findViewById(R.id.fithLesson);
                if(et.getText()!=null)
                    dal.updateScheduleSubject(day, 5, getIntent().getIntExtra("userid",0), et.getText().toString());
                else dal.updateScheduleSubject(day, 5, getIntent().getIntExtra("userid",0), "");
                et = inflater.findViewById(R.id.sixthLesson);
                if(et.getText()!=null)
                    dal.updateScheduleSubject(day, 6, getIntent().getIntExtra("userid",0), et.getText().toString());
                else dal.updateScheduleSubject(day, 6, getIntent().getIntExtra("userid",0), "");
                et = inflater.findViewById(R.id.seventhLesson);
                if(et.getText()!=null)
                    dal.updateScheduleSubject(day, 7, getIntent().getIntExtra("userid",0), et.getText().toString());
                else dal.updateScheduleSubject(day, 7, getIntent().getIntExtra("userid",0), "");
                et = inflater.findViewById(R.id.eighthLesson);
                if(et.getText()!=null)
                    dal.updateScheduleSubject(day, 8, getIntent().getIntExtra("userid",0), et.getText().toString());
                else dal.updateScheduleSubject(day, 8, getIntent().getIntExtra("userid",0), "");
                et = inflater.findViewById(R.id.ninethLesson);
                if(et.getText()!=null)
                    dal.updateScheduleSubject(day, 9, getIntent().getIntExtra("userid",0), et.getText().toString());
                else dal.updateScheduleSubject(day, 9, getIntent().getIntExtra("userid",0), "");

                updateList(day);
            }
        });
        builder.setNegativeButton("Cancel", null);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
}
    // do something with the data coming from the AlertDialog
    private void sendDialogDataToActivity(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        updateList(position);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void getScheduleData(){
        ScheduleSubject sb = new ScheduleSubject(1,"Math");
    }

    public void updateList(int pos){
        ScheduleSubjectAdapter sba = new ScheduleSubjectAdapter(this,R.layout.schedule_subject,dal.getDayschedule(pos, getIntent().getIntExtra("userid",0)));
        list.setAdapter(sba);
    }
}