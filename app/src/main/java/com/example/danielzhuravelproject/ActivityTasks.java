package com.example.danielzhuravelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class ActivityTasks extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lstViewTasks;
    ArrayList<Task> arrTasks = new ArrayList<Task>();
    TaskAdapter ta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        lstViewTasks = findViewById(R.id.listViewTasks);

        getTaskData();
        ta = new TaskAdapter(this, R.layout.task,arrTasks);
        lstViewTasks.setAdapter(ta);
        lstViewTasks.setOnItemClickListener(this);
    }

    private void getTaskData() {
        Task t = new Task("Math", "73.5.1942", "Do a Flipidifloop",false,this);

        arrTasks.add(t);
        t = new Task("English", "59.10.2025", "Write a Task", false,this);
        arrTasks.add(t);
        t = new Task ("PE", "43.15.17", "Jump", false,this);
        arrTasks.add(t);
    }

    public void deleteDoneTasks(View view){
        int size = arrTasks.size();
        for(int i=0;i< size;i++)
        {
            if(arrTasks.get(i).isCheckBox()){
                arrTasks.remove(i);
                Toast.makeText(this, "in", Toast.LENGTH_SHORT).show();
            }

        }
        TaskAdapter ta = new TaskAdapter(this, R.layout.task,arrTasks);
        lstViewTasks.setAdapter(ta);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ta.getChecked(view,position);
        Toast.makeText(this, "in on item", Toast.LENGTH_SHORT).show();
        Log.i("blabla","In onclick");

    }
}