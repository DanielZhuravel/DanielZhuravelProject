package com.example.danielzhuravelproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends ArrayAdapter<Task> {
    private Context ctx;
    private int TaskResourceId;
    private List<Task> data;

    public TaskAdapter(@NonNull Context context, int resource, @NonNull List<Task> objects) {
        super(context, resource, objects);
        this.ctx = (ActivityTasks) context;
        this.TaskResourceId = resource;
        this.data = objects;

    }
    @Override
    public int getCount(){
        return data.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(this.TaskResourceId,null);

        Task t = this.data.get(position);
        TextView tvsubject = v.findViewById(R.id.tvSubjectname);
        tvsubject.setText(t.getSubject());
        TextView tvgrade = v.findViewById(R.id.tvTaskTodo);
        tvgrade.setText(t.getTaskTodo()+"");
        TextView tvdate = v.findViewById(R.id.tvdueDate);
        tvdate.setText(t.getDueDate());
        ImageView imgSub = v.findViewById(R.id.imageSubject);
        imgSub.setImageBitmap(t.getSubjectimg());
        return v;

    }

    public void getChecked(View view, int position){
        Task task = this.data.get(position);
        CheckBox cb;
        cb = view.findViewById(R.id.checkBoxDone);
        task.setCheckBox(cb.isChecked());
    }
}
