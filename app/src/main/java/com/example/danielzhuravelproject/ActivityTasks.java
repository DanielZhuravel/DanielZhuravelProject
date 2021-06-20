package com.example.danielzhuravelproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class ActivityTasks extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lstViewTasks;
    ArrayList<Task> arrTasks = new ArrayList<Task>();
    TaskAdapter ta;
    Dal dal;
    String subject;
    String whatToDo;
    String dueDate;
    ArrayList<Task> selectedTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        lstViewTasks = findViewById(R.id.listViewTasks);


        dal = new Dal(this);
        arrTasks = dal.getAllTasksByid(getIntent().getIntExtra("userid",0));
//        arrTasks = dal.getAllTasks();

        ta = new TaskAdapter(this, R.layout.task,arrTasks);
        lstViewTasks.setAdapter(ta);
        lstViewTasks.setOnItemClickListener(this);

        selectedTasks = new ArrayList<>();
    }

 private void getTaskData() {
        Task t = new Task("Math", "73.5.1942", "Do a Flipidifloop",this);

        arrTasks.add(t);
        t = new Task("English", "59.10.2025", "Write a Task",this);
        arrTasks.add(t);
        t = new Task ("PE", "43.15.17", "Jump",this);
        arrTasks.add(t);
    }

    public void deleteDoneTasks(View view){
        int i = 0;
        while (!arrTasks.isEmpty() && i < arrTasks.size())
        {
            Task task = arrTasks.get(i);
            if(arrTasks.get(i).isCheckBox()){
                dal.deleteDoneTasks(arrTasks.get(i).getTaskID());
                arrTasks.remove(i);
            }
            else i++;

        }
        TaskAdapter ta = new TaskAdapter(this, R.layout.task,arrTasks);
        lstViewTasks.setAdapter(ta);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ta.getChecked(view,position);
        Toast.makeText(this, "in on item", Toast.LENGTH_SHORT).show();

    }

    public void addTask(View view) {
        final Task t = new Task();
        LayoutInflater linf = LayoutInflater.from(this);
        final View inflater = linf.inflate(R.layout.task_alert_dialog_layout,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ADD TASK");
        final View customLayout = getLayoutInflater().inflate(R.layout.task_alert_dialog_layout, null);
        builder.setView(inflater);
        builder.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText et = inflater.findViewById(R.id.subjectET);
                boolean flag = true;
                if(!et.getText().toString().matches(""))
                    t.setSubject(et.getText().toString());
                else {
                    Toast.makeText(ActivityTasks.this, "All plains must be filled", Toast.LENGTH_SHORT).show();
                    flag = false;
                }
                et = inflater.findViewById(R.id.contextET);
                if(!et.getText().toString().matches(""))
                    t.setTaskTodo(et.getText().toString());
                else {
                    Toast.makeText(ActivityTasks.this, "All plains must be filled", Toast.LENGTH_SHORT).show();
                    Log.i("test", "in");
                    flag = false;
                }
                et = inflater.findViewById(R.id.dueDateET);
                if(!et.getText().toString().matches(""))
                    t.setDueDate(et.getText().toString());
                else {
                    Toast.makeText(ActivityTasks.this, "All plains must be filled", Toast.LENGTH_SHORT).show();
                    flag = false;
                }
                if(flag){
                    t.setDefaultImg(ActivityTasks.this);
                    dal.addTask(t, getIntent().getIntExtra("userid",0));
                    arrTasks = dal.getAllTasksByid(getIntent().getIntExtra("userid",0));
                    ta = new TaskAdapter(ActivityTasks.this, R.layout.task,arrTasks);
                    lstViewTasks.setAdapter(ta);
                }

            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();

       /* AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle("what's the subject?");
        final EditText input1 = new EditText(this);
        LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input1.setLayoutParams(lp1);
        builder1.setView(input1);
        builder1.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                t.setSubject("" + input1.getText().toString());
            }
        });
        builder1.show();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("what you got to do?");
        final EditText input = new EditText(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        builder.setView(input);
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                t.setTaskTodo("" + input.getText().toString());
            }
        });
        builder.show();

        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder.setTitle("Due date?");
        final EditText input2 = new EditText(this);
        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp2);
        builder2.setView(input2);
        builder2.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                t.setDueDate(""+input2.getText().toString());
            }
        });
        builder2.show();

        dal.addTask(t); */
    }
}