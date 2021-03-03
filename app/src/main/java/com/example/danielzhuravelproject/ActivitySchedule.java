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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Toast.makeText(this,""+getDayNum() , Toast.LENGTH_SHORT).show();

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
        LayoutInflater linf = LayoutInflater.from(this);
        final View inflater = linf.inflate(R.layout.custom_layout,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Edit "+sp.getSelectedItem()+" Schedule");
        final View customLayout = getLayoutInflater().inflate(R.layout.custom_layout, null);
        builder.setView(inflater);
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                schedules.get(day).clear();
                EditText et = inflater.findViewById(R.id.firstLesson);
                int day = sp.getSelectedItemPosition();
                if(et.getText()!=null)
                    schedules.get(day).add(new ScheduleSubject(1,et.getText().toString()));
                else schedules.get(day).add(new ScheduleSubject(1,""));
                et = inflater.findViewById(R.id.secodLesson);
                if(et.getText()!=null)
                    schedules.get(day).add(new ScheduleSubject(2,et.getText().toString()));
                else schedules.get(day).add(new ScheduleSubject(2,""));
                et = inflater.findViewById(R.id.thirdLesson);
                if(et.getText()!=null)
                    schedules.get(day).add(new ScheduleSubject(3,et.getText().toString()));
                else schedules.get(day).add(new ScheduleSubject(3,""));
                et = inflater.findViewById(R.id.fourthLesson);
                if(et.getText()!=null)
                    schedules.get(day).add(new ScheduleSubject(4,et.getText().toString()));
                else schedules.get(day).add(new ScheduleSubject(4,""));
                et = inflater.findViewById(R.id.fithLesson);
                if(et.getText()!=null)
                    schedules.get(day).add(new ScheduleSubject(5,et.getText().toString()));
                else schedules.get(day).add(new ScheduleSubject(5,""));
                et = inflater.findViewById(R.id.sixthLesson);
                if(et.getText()!=null)
                    schedules.get(day).add(new ScheduleSubject(6,et.getText().toString()));
                else schedules.get(day).add(new ScheduleSubject(6,""));
                et = inflater.findViewById(R.id.seventhLesson);
                if(et.getText()!=null)
                    schedules.get(day).add(new ScheduleSubject(7,et.getText().toString()));
                else schedules.get(day).add(new ScheduleSubject(7,""));
                et = inflater.findViewById(R.id.eighthLesson);
                if(et.getText()!=null)
                    schedules.get(day).add(new ScheduleSubject(8,et.getText().toString()));
                else schedules.get(day).add(new ScheduleSubject(8,""));
                et = inflater.findViewById(R.id.ninethLesson);
                if(et.getText()!=null)
                    schedules.get(day).add(new ScheduleSubject(9,et.getText().toString()));
                else schedules.get(day).add(new ScheduleSubject(9,""));

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
        ScheduleSubjectAdapter sba = new ScheduleSubjectAdapter(this,R.layout.schedule_subject,schedules.get(pos));
        list.setAdapter(sba);
    }
}